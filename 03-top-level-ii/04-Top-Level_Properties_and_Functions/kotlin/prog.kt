class SomeClass(val num : Int) {
	fun msc() { println("SomeClass(${num})") }
}

var x = 1234

fun func(y : Int) = x + y

fun SomeClass.xmsc(nnn : Int) {
	println("SomeClass(${num+nnn})")
}

fun SomeClass_xmsc(self : SomeClass, nnn : Int) {
	println("SomeClass(${self.num+nnn})")
}

fun main() {
	x += 16
	println("calc: " + func(50))
	val sc = SomeClass(55)
	sc.msc()
	sc.xmsc(33)
	SomeClass_xmsc(sc, 33)
}
