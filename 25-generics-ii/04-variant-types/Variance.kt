// We redeclare in Kotlin two functional interfaces from Java,
// explicitly allowing variance in the generic type parameters

interface Consumer<T> {
	fun accept(obj: T): Unit
}

interface Supplier<out T> {
	fun get(): T
}

// Then we define a new type that implements both interfaces,
// one allowing covariance, the other contravariance

class Transformer<T,R>(
	initial: T,
	private val transformation: (T)->R
)	: Consumer<T>, Supplier<R> {
	private var value = initial
	
	override fun get() : R = transformation(value)
	
	override fun accept(obj: T) { value = obj }
}

fun textToInt(text: CharSequence) : Int =
	Integer.parseInt(text.toString())

fun main() {

	// Although the second parameter of Transformer's constructor
	// is (String) -> Int, we can also pass as argument a function
	// of (CharSequence) -> Int, where CharSequence is a supertype
	// of String. Why?
	// Hint: the formal type of 'transformation' is Function1
	//      (see https://tinyurl.com/Function1-kt in GitHub)

	val transformer =
		Transformer<String, Int>("0", ::textToInt)

	// Although Transformer<String, Int> is a Supplier<Int>, we
	// can also see it as a Supplier<Number>, where Number is a 
	// supertype of Int. Why? (see Supplier in line 8)

	val numberSource : Supplier<Number> = transformer
	
	val v1: Number = numberSource.get()
	println("v1: ${ v1::class.simpleName }($v1)")
	
	transformer.accept("888")
	
	val v2: Number = numberSource.get()
	println("v2: ${ v2::class.simpleName }($v2)")
}
