package pt.isel.leic.lae

class ClassWithProperties(
	number : Int, val txt : String, var flt : Double
) {
	val num = number + 1000

	fun mcwp() {
		println("num: ${num} ; txt: ${txt} ; flt: ${flt}")
	}
}

fun inspect(obj : Any) {
	println("--------")
	
	val kcls = obj::class
	
	println("inspector : " + kcls::class.simpleName)
	println("full  name: " + kcls.qualifiedName)
	println("short name: " + kcls.simpleName)
	
	println("--------")
	println("members: [")
	kcls.members.forEach {
		println("   " + it)  // show all members of obj's type
		if (it.name == "mcwp") {
			print("      >>>   ")
			it.call(obj)
		}
	}
	println("]")
}

fun main() {
	println("--------")
	
	val kcls = ClassWithProperties::class
	
	println("inspector : " + kcls::class.simpleName)
	println("full  name: " + kcls.qualifiedName)
	println("short name: " + kcls.simpleName)
	
	val cls = kcls.java

	println("inspector : " + cls::class.simpleName)
	println("full  name: " + cls.canonicalName)
	println("short name: " + cls.simpleName)
	
	val obj = ClassWithProperties(10, "LAE", 1.2345)
	
	inspect(obj)
	
	val str = "ISEL - LEIC - LAE"
	
	inspect(str)
}
