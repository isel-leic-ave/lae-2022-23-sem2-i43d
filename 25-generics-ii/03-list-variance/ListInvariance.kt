open class A       { val one   = 1 }
open class B : A() { val two   = 2 } 
open class C : B() { val three = 3 } 

//  C is a B  and  B is an A
//  but
//  MutableList<B> is not a MutableList<A>
//  and
//  MutableList<B> is not a MutableList<C>

//  Yet, sometimes some casts might work,
//  as type erasure prevents some validations
//  to be effective, and some operations are
//  indeed possible.

//  We can pass a MutableList<B> where a
//  MutableList<A> is expected *if and only if*
//  we only take As out of the MutableList but 
//  never try to add them.

//  We can pass a MutableList<B> where a
//  MutableList<C> is expected *if and only if*
//  we only put Cs into the MutableList but
//  never try to take them out.

//  Use the code below as a base for experimenting
//  with these ideas.

private fun processAs(aas: MutableList<A>) : Int {
	var total = 0
	for (a in aas) {
		total += a.one
	}
	//aas.add(A())  // is this ok?
	return total
}

private fun processBs(abs: MutableList<B>) : Int {
	var total = 0
	for (b in abs) {
		println(".")
		total += b.two
	}
	abs.add(B())  // is this ok?
	return total
}

private fun processCs(acs: MutableList<C>) : Int {
	var total = 0
	//for (c in acs) {
	//	total += c.three  // is this ok?
	//}
	acs.add(C())  // is this ok?
	return total
}

fun main() {
	
	val bs = mutableListOf<B>(B(), B(), C(), B())
	
	println(":: Process A ::")
	val ta = processAs(bs)                     // is this allowed?
	//val ta = processAs(bs as MutableList<A>)   // is this ok?
	println(ta)
	
	println(":: Process B ::")
	val tb = processBs(bs)
	println(tb)

	println(":: Process C ::")
	val tc = processCs(bs)                     // is this allowed?
	//val tc = processCs(bs as MutableList<C>)   // is this ok?
	println(tc)
	
	println(":: Process B ::")
	val tb2 = processBs(bs)
	println(tb2)
}
