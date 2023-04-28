open class A       { val one   = 1 }
open class B : A() { val two   = 2 } 
open class C : B() { val three = 3 } 

//  C is a B  and  B is an A
//  therefore
//  MutableList<out B> is a MutableList<out A>
//  and
//  MutableList<in B> is a MutableList<in C>

//  With a MutableList<out T>, in every method of
//  MutableList, arguments of type T are treated
//  as having type Nothing (a formal subtype of
//  every type) and cannot be used in practice.

//  With a MutableList<in T>, in every method of
//  MutableList, a return type of T is treated
//  as Any (a formal supertype of every type).

//  Use the code below as a base for experimenting
//  with these ideas.

private fun processAs(aas: MutableList<out A>) : Int {
	var total = 0
	for (a in aas) {
		total += a.one
	}
	//aas.add(A())  // is this allowed?
	return total
}

private fun processBs(abs: MutableList<B>) : Int {
	var total = 0
	for (b in abs) {
		total += b.two
	}
	abs.add(B())  // is this allowed?
	return total
}

private fun processCs(acs: MutableList<in C>) : Int {
	var total = 0
	//for (c in acs) {
	  //total += c.three       // why is this not allowed?
		//total += c.hashCode()  // but this one is?
	//}
	acs.add(C())  // is this allowed?
	return total
}

fun main() {
	
	val bs = mutableListOf<B>(B(), B(), C(), B())
	
	println(":: Process A ::")
	val ta = processAs(bs)   // is this allowed?
	println(ta)
	
	println(":: Process B ::")
	val tb = processBs(bs)
	println(tb)

	println(":: Process C ::")
	val tc = processCs(bs)   // is this allowed?
	println(tc)
	
	println(":: Process B ::")
	val tb2 = processBs(bs)
	println(tb2)
}
