class SomeClass(val num : Int) {
	fun msc() { println("SomeClass(${num})") }
}

var x = 1234

fun func(y : Int) = x + y

fun main() {
	x += 16
	println("calc: " + func(50))
	val sc = SomeClass(55)
	sc.msc()
}