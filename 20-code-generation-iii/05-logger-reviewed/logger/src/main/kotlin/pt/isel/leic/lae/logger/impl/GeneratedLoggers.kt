package pt.isel.leic.lae.logger

import org.cojen.maker.*

import java.io.*
import java.net.URLClassLoader

import kotlin.reflect.*
import kotlin.reflect.jvm.*
import kotlin.reflect.full.*

/* The producer of dinamically generated loggers.
 * Saves all generated loggers into a well-known (configurable) directory, such
 * that they can be reused in subsequent executions of the program.
 *
 * Caveat:
 *   if types are changed between executions, the previously generated loggers
 *   may become invalid and produce wrong results or cause runtime exceptions
 *
 * TO DO :
 *   if some property is not trivially loggable, recursively call Logger.log
 *   (with the same StringBuilder and level + 1) for that property, in order
 *   to delegate logging on another SpecificLogger
 */

object GeneratedLoggers {

	const val OUTPUT_DIR_ENVVAR = "LOGGER_OUTPUT_DIR"
	const val DEFAULT_OUTPUT_DIR = "output"

	val outputDir =
		File(
			System.getenv(OUTPUT_DIR_ENVVAR) ?:
			DEFAULT_OUTPUT_DIR
		)

	init { outputDir.mkdirs() }
	
	private val classLoader =
		URLClassLoader.newInstance(
			arrayOf(outputDir.toURI().toURL())
		)
	
	private fun loggerClassNameFor(klass: KClass<Any>) =
		"LoggerFor${ klass.simpleName }"
	
	fun	loadLoggerFor(klass: KClass<Any>) : Logger.SpecificLogger {
		val loggerClass = classLoader.loadClass(loggerClassNameFor(klass))
		val loggerCtor = loggerClass.getConstructor()
		val logger = loggerCtor.newInstance() as Logger.SpecificLogger
		return logger
	}
	
	fun	newLoggerFor(klass: KClass<Any>) : Logger.SpecificLogger {
		val loggerMaker = makeLogger(klass)
		
		val loggerClassFile =	
			File(
				outputDir,
				"${ loggerClassNameFor(klass) }.class"
			)
		loggerClassFile.createNewFile()
		FileOutputStream(loggerClassFile, false).use {
			fileStream -> loggerMaker.finishTo(fileStream)
		}
		
		return loadLoggerFor(klass)
	}

	/* This base class for generated loggers allows the generated classes to be smaller.
	 * The generated code is also arguably more readable. Try it with the Procyon decompiler
	 * in BytecodeViewer. Set: View > Pane 1 > Procyon > Java
	 */
	abstract class BaseSpecificLogger() : Logger.SpecificLogger {
		protected fun newline(sbuilder: StringBuilder) { sbuilder.append('\n') }

		protected fun write(sbuilder: StringBuilder, level: Int, str: String) =
			tabs(sbuilder, level).append(str)

		private fun tabs(sbuilder: StringBuilder, level: Int) : StringBuilder {
			repeat(level) { sbuilder.append("  ") }
			return sbuilder
		}
	}

	private fun	makeLogger(klass: KClass<Any>) : ClassMaker {
		val classMaker =
			ClassMaker.beginExternal(loggerClassNameFor(klass))
			          .public_()
			          .extend(BaseSpecificLogger::class.java)

		classMaker.addConstructor().public_()

		val logMethodMaker =
			classMaker.addMethod(
				null,
				"log",
				StringBuilder::class.java,
				Int::class.java,
				Object::class.java
			).override().public_()

		makeLogMethod(logMethodMaker, klass)

		return classMaker
	}

	private fun makeLogMethod(logMaker: MethodMaker, klass: KClass<Any>) {
		val sbuilder = logMaker.param(0)
		val level = logMaker.param(1)
		val obj = logMaker.param(2).cast(klass.java)

		logMaker.invoke("newline",
			logMaker.invoke("write", sbuilder, level, "${ klass.simpleName } {")
		)

		klass.memberProperties.filter { prop ->
			prop.visibility == KVisibility.PUBLIC
		}.forEach { prop ->
			val getter = prop.javaGetter
			val value = 
				logMaker
					.`var`((prop.returnType.classifier as KClass<*>).java)
					.set(
						if (getter != null) {
							obj.invoke(getter.name)
						} else {
							obj.field(prop.javaField?.name).get()
						}
					)
			logMaker.invoke("newline",
				logMaker.invoke("write", sbuilder, level.add(1), "${ prop.name } : ")
				        .invoke("append", value)
		  )
		}

		logMaker.invoke("newline",
			logMaker.invoke("write", sbuilder, level, "}")
		)
	}
}
