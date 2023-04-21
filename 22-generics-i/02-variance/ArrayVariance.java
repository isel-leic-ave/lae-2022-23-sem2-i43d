class A { public int getOne() { return 1; } }
class B extends A { public int getTwo() { return 2; } } 
class C extends B { public int getThree() { return 3; } } 

public class ArrayVariance {

	private static int processAs(A[] aas) {
		int total = 0;
		for (int i = 0; i < aas.length; ++i) {
			total += aas[i].getOne();
			//aas[i] = new A();   // is this allowed?
		}
		return total;
	}

	private static int processCs(C[] acs) {
		int total = 0;
		for (int i = 0; i < acs.length; ++i) {
			total += acs[i].getThree();
		}
		return total;
	}
	
	public static void main(String[] args) {
		
		B[] bs = new B[] { new B(), new B(), new B(), new B() };
		
		int ta = processAs(bs);
		System.out.println(ta);

		//int tc = processCs(bs);   // not possible
		//System.out.println(tc);
	}
}
