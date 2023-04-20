package pt.isel.leic.lae.logger

import kotlin.reflect.*
import kotlin.reflect.full.*

/* A last resort creator of reflection-based loggers.
 * These are used whenever dynamic logger generation or loading fails for some reason.
 * We try to move most reflection actions to the construction of each LoggerForClass,
 * thereby minimizing reflection actions during the execution of the 'log' method.
 *
 * TO DO :
 *   if some property is not trivially loggable, recursively call Logger.log
 *   (with the same StringBuilder and level + 1) for that property, in order
 *   to delegate logging on another SpecificLogger
 */

object ReflectionLoggers {
	
	fun	newLoggerFor(klass: KClass<Any>) : Logger.SpecificLogger =
		LoggerForClass(klass)

	private class LoggerForClass(klass: KClass<Any>) : Logger.SpecificLogger {
		private val name = klass.simpleName

		private val props =
			klass.memberProperties.filter { prop ->
				prop.visibility == KVisibility.PUBLIC
			}.toList()

		override fun log(sbuilder: StringBuilder, level: Int, obj: Any) {
			sbuilder.logln(level, "$name {")
			props.forEach { prop ->
				sbuilder.logln(
					level + 1,
					"${ prop.name } : ${ prop.get(obj) }"
				)
			}
			sbuilder.logln(level, "}")
		}
		
		private fun StringBuilder.logln(level: Int, str: String) {
			repeat(level) { append("  ") }
			append(str).append('\n')
		}
	}
}
