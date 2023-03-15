import kotlin.reflect.*
import kotlin.reflect.full.*

@Target(AnnotationTarget.PROPERTY, AnnotationTarget.CLASS)
annotation class NoLog

@Target(AnnotationTarget.CLASS)
annotation class AltName(val name : String)

object Logger {

	fun log(obj : Any?) {
		if (obj == null) {
			println("null")
		} else {
		
			@Suppress("UNCHECKED_CAST")
			val klass = obj::class as KClass<Any>
			
			val altName = klass.findAnnotation<AltName>()
			val name = altName?.name ?: klass.simpleName
			
			println("${ name } {")
			klass.memberProperties.forEach { prop ->
				if (prop.visibility == KVisibility.PUBLIC &&
				   !prop.hasAnnotation<NoLog>()) {
					println("  ${ prop.name } : ${ prop.get(obj) }")
				}
			}
			println("}")
		}
	}
	
}
