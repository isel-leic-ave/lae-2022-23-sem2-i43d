private interface I {}
private open class B() : I {}
private class D() : B() {}

private fun upcast1(value: Int?) : Any? = value    // no checkcast
private fun upcast2(value: B?) : I? = value        // checkcast in upcast?
private fun upcast3(value: D?) : B? = value        // checkcast in upcast?

// all downcasts must be explicit and generate checkcast instructions
private fun downcast1(value: Any?) : Int? = value as Int?   
private fun downcast2(value: I?) : B? = value as B?
private fun downcast3(value: B?) : D? = value as D?

private fun <T> identity(value: T?) : T? = value   // no checkcast

// due to type erasure (JVM does not support generics), all usages
// of generic functions/methods require casts of output values
private fun passThrough(value: Int?)    : Int?    = identity(value)  // checkcast
private fun passThrough(value: String?) : String? = identity(value)  // checkcast

fun main() {
	val u1 = upcast1(1234)
	val u2 = upcast2(B())
	val u3 = upcast3(D())

	val d1 = downcast1(1234)
	val d2 = downcast2(B())
	val d3 = downcast3(D())

	val i1 = passThrough(1234)
	val i2 = passThrough("ISEL")

	println(u1)
	println(u2)
	println(u3)

	println(d1)
	println(d2)
	println(d3)

	println(i1)
	println(i2)
}
