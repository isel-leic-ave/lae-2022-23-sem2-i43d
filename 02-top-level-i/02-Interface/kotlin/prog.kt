interface AnInterface {
	fun mi() : Unit
}

open class ClassWithInterface : AnInterface {

	open fun mcwi() { println("ClassWthInterface") }
	
	override fun mi() { println("AnInterface implementation") }
}

fun main() {
	val ii : AnInterface = ClassWithInterface()
	ii.mi()
	
	val cwi = ClassWithInterface()
	cwi.mcwi()
}
