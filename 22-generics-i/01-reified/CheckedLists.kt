import kotlin.reflect.*

/* Cast any List<*> to List<R>.  [but it doesn't work!]
 * Due to type erasure, the cast is, in fact, useless,
 * as there is not enough runtime information to perform
 * the operation effectively.
 */
fun <R : Any> List<*>.notReallyCheckedAs() : List<R> {
	@Suppress("UNCHECKED_CAST")
	return this as List<R>
}

/* Cast any List<*> to List<R>.
 * A technique widely-used in Java is to explicitly pass
 * the target type Class/KClass as an argument, which exposes
 * the target type information in runtime.
 * However, a simple cast on the List is not enough, as the 
 * list itself is subjected to type-erasure in runtime. Hence
 * the function checks the list elements one by one.
 */
fun <R : Any> List<*>.checkedAs(klass: KClass<R>) : List<R> {
	forEach { klass.cast(it) }
	@Suppress("UNCHECKED_CAST")
	return this as List<R>
}

/* In Kotlin, an inline function will have its code expanded
 * directly by the compiler at each call site. It is therefore
 * possible to use different Rs in each expansion and to have 
 * R type information effectively available in runtime without
 * a Class/KClass having to be passed explicitly.
 * The keyword reified enables that behaviour.
 * To avoid inline expasions to take too much space, you may
 * use the inline function to call the non-inline version
 * passing the appropriate Class/KClass.
 */
inline fun <reified R : Any> List<*>.checkedAs() =
	checkedAs(R::class)

/*
inline fun <reified R : Any> List<*>.checkedAs() : List<R> {
	forEach { it as R }
	@Suppress("UNCHECKED_CAST")
	return this as List<R>
}
*/

open class A(val txt: String)

open class B(str : String) : A(str) {
	fun show() { println(txt) }
} 

fun main() {
	val objs = listOf(B("ISEL"), B("LEIC"), B("LAE")) as List<Any?>

	val lobs1 = objs.checkedAs(B::class)
	val lobs2 = objs.checkedAs<B>()
	val lobs3 : List<B> = objs.checkedAs()

	println(":: CAST OK ::")
	Thread.sleep(5000)

	for (r in lobs3) {
		r.show()
	}
}
