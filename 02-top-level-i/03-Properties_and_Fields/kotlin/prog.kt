class ClassWithProperties(
	number: Int,
	val txt : String,
	var flt: Double
) {

	val num = number + 1000

	fun mcwp() { 
		println("num: $num ; txt: $txt ; flt: $flt")
	}
}

fun main() {
	val cwp = ClassWithProperties(
		8,
		"ISEL",
		3.141592654
	)
	cwp.mcwp()
}
