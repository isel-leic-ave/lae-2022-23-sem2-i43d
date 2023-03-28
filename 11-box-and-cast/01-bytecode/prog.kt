fun foo(a : Int, b : Int) : Int {
	var c = 0
	c += a
	c += b
	return c
}

fun String?.or(alt : String) : String {
	return if (this == null) alt else this
}

fun main() {
	println(foo(3, 4))
	println(foo(5, 6))
	
	val str : String? = null
	println(str.or("ISEL"))
}
