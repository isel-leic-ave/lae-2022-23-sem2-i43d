// Java code equivalent to the Kotlin version
// in ../ListVariance.kt

// Notice:
//   ArrayList<? extends A>  instead of  MutableList<out A>
// and
//   ArrayList<? super C>    instead of  MutableList<in C>

// In Kotlin we express the intended usage (out, in) and
// the corresponding variance is implied: 
//   - covariance for out
//   - contravariance for in

// In Java we express the intended variance (extends for
// covariance, super for contravariance) and the allowable
// usage is implied: 
//   - only 'out' for covariance
//   - only 'in' for contravariance

//  Use the code below as a base for experimenting
//  with these ideas.

import java.util.ArrayList;
import java.util.Arrays;

class A           { public int getOne()   { return 1; } }
class B extends A { public int getTwo()   { return 2; } } 
class C extends B { public int getThree() { return 3; } } 

public class ListVariance {
	
	private static int processAs(ArrayList<? extends A> aas) {
		var total = 0;
		for (var a : aas) {
			total += a.getOne();
		}
		//aas.add(new A());  // is this allowed?
		return total;
	}

	private static int processBs(ArrayList<B> abs) {
		var total = 0;
		for (var b : abs) {
			total += b.getTwo();
		}
		abs.add(new B());  // is this allowed?
		return total;
	}

	private static int processCs(ArrayList<? super C> acs) {
		var total = 0;
		//for (var c : acs) {
		//	total += c.getThree();
		//}
		acs.add(new C());  // is this allowed?
		return total;
	}

	public static void main(String[] args) {
		
		final var bs = new ArrayList<B>(
			Arrays.asList(new B(), new B(), new C(), new B())
		);
		
		System.out.println(":: Process A ::");
		final var ta = processAs(bs);
		System.out.println(ta);
		
		System.out.println(":: Process B ::");
		final var tb = processBs(bs);
		System.out.println(tb);

		System.out.println(":: Process C ::");
		final var tc = processCs(bs);
		System.out.println(tc);
		
		System.out.println(":: Process B ::");
		final var tb2 = processBs(bs);
		System.out.println(tb2);
	}
}