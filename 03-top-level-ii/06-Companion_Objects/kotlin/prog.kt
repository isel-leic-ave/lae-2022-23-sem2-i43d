class ClassWithCompanion(private val n : Int) {

	// Declares a new type with a single instance
	// which contains common data and operations
	// for all instances of ClassWithCompanion.
	// This is usually achieved in Java with
	// static fields and methods, but in Kotlin
	// there's a type (and instance) for that.
	companion object {
		public var counter = 0
		public var lastCreatedWith : Int? = null
		
		fun showLast() { println("last: ${lastCreatedWith}") }
	}
	
	// An initializer block runs initialitazion code for
	// an instance. In Java, this code would belong to 
	// a constructor.
	init {
		counter++
		lastCreatedWith = n
	}

	fun mcwc() {
		println("ClassWithCompanion(${n}) [total: ${counter}]")
	}
}

fun main() {
	// Members of the companion object can be accessed using
	// the enclosing type name.
	ClassWithCompanion.showLast()
	
	val cwc1 = ClassWithCompanion(111)
	val cwc2 = ClassWithCompanion(222)
	val cwc3 = ClassWithCompanion(333)
	
	cwc1.mcwc()
	cwc2.mcwc()
	cwc3.mcwc()

	// Members of the companion object can also be accessed
	// using the name of the companion object type. By default,
	// the name of the companion object type is Companion.
	ClassWithCompanion.Companion.showLast()
}
