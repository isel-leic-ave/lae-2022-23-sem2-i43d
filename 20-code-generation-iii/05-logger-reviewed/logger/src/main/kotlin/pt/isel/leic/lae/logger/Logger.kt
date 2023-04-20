package pt.isel.leic.lae.logger

import java.util.concurrent.*
import kotlin.concurrent.*
import kotlin.reflect.*

/* A demo project using techniques from both PC and LAE courses. */

object Logger {

	/* We will use a single-threaded executor to load and generate .class files.
	 * Generating and loading .class files will therefore use at most one CPU
	 * core, but may exhibit a larger latency when compared to a multithreaded
	 * solution.
	 * The executor thread will be a daemon thread, allowing the program to
	 * terminate promptly, but also potentially leading to loss of log data.
	 */

	private class DaemonThreadFactory : ThreadFactory {
		override fun newThread(r: Runnable) =
			thread(isDaemon = true, start = false) { r.run() }
	}

	private val executor = 
		Executors.newSingleThreadExecutor(DaemonThreadFactory())

	/* There will be two different kinds of loggers:
	 *  - generated via Cojen/Maker
	 *  - reflection-based loggers, as a last resort (if anything fails during code loading or generation)
	 * Both will implement the following interface.
	 */

	interface SpecificLogger {
		fun log(sbuilder: StringBuilder, level: Int, obj: Any)
	}

	/* The map-of-futures solution for concurrently-accessed lazy-initialized resources.
	 * This is a *very* common problem, and here you can observe a well-known solution
	 * for it with a concurrent map of futures.
	 * The first access to an entry with some key will immediately result in a Future
	 * for the desired value being associated with that entry. Subsequent accesses to
	 * the same key will find the Future in place, meaning that the process of obtaining
	 * the value has already started (and may or may not have finished).
	 * Using computeIfAbsent (with no Futures or Executors) is enough for cases where
	 * producing the value does not take an excessive amount of time. This solution
	 * with Futures and an Executor gives us more control over participating threads.
	 */

	private val loggers =
		ConcurrentHashMap<KClass<Any>, Future<SpecificLogger>>()

	/* print and println to console are atomic
	 * If log is invoked simultaneously by several threads, we avoid having
	 * log messages mixed up in the console by creating independent strings
	 * for each call (using a different StringBuilder in each of those calls)
	 * and calling print only once with the final string
	 */

	fun log(obj : Any?) {
		val sbuilder = StringBuilder()
		log(sbuilder, 0, obj)
		print(sbuilder.toString())
	}
	
	fun log(sbuilder: StringBuilder, level: Int, obj: Any?) {
		if (obj == null) {
			sbuilder.append("null\n")
		} else {
			@Suppress("UNCHECKED_CAST")
			val klass = obj::class as KClass<Any>

			val logger =
				loggers.computeIfAbsent(klass, ::obtainSpecificLogger)  // quickly returns a Future
				       .get()                                           // may block the invoking thread

			logger.log(sbuilder, level, obj)
		}
	}

	/* Try to load or generate-then-load a specific logger for klass.
	 * In case of failure during the generation or loading of the specific logger,
	 * we resort to a reflection-based logger.
	 * obtainSpecificLogger quickly returns a Future; this Future, in turn, will only
	 * become resolved whenever some SpecificLogger for klass is finally produced.
	 */

	private fun obtainSpecificLogger(klass: KClass<Any>) =
		executor.submit<SpecificLogger> {
			try {
				loadSpecificLogger(klass)
			} catch (ex : Exception) {
				println("""
					|##################
					|## Logger ERROR ##
					|## Failed to load/create a logger for ${ klass.simpleName}
					|${ ex }
					|##################
					""".trimMargin())

				println(":: Creating a reflection logger for ${ klass.simpleName } ::")
				ReflectionLoggers.newLoggerFor(klass)
			}
		}

	private fun loadSpecificLogger(klass: KClass<Any>) =
		try {
			val logger = GeneratedLoggers.loadLoggerFor(klass)
			println(":: Loaded existing logger for ${ klass.simpleName } ::")
			logger
		} catch (cnfe : ClassNotFoundException) {
			println(":: Generating a new logger for ${ klass.simpleName } ::")
			GeneratedLoggers.newLoggerFor(klass)
		}
}
