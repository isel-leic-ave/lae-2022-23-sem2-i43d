open class Pair(val a: Int, val b: Int) {
	open fun show() {
		print("a: $a; b: $b; ")
	}
}

class Triple(a: Int, b: Int, val c: Int) : Pair(a, b) {
	override fun show() {
		super.show()                // non-virtual invokespecial: must end up in Pair.show
		print("c: $c; ")
	}
}

fun showPairOrTriple(obj: Pair) {
	obj.show()                    // virtual method invoked via invokevirtual
	                              // ends up in Pair.show or Triple.show depending on obj 
	println()
}

fun main() {
	val pair   = Pair(2, 3)       // constructors invoked via invokespecial
	val triple = Triple(4, 5, 6)  // constructors invoked via invokespecial
	
	showPairOrTriple(pair)
	showPairOrTriple(triple)
}
