interface I {}
class B implements I {}
final class D extends B {}

public class Prog {

	static Object  upcast1(Integer value)  { return value; }           // no checkcast
	static I       upcast2(B value)        { return value; }           // no checkcast
	static B       upcast3(D value)        { return value; }           // no checkcast

	static Integer downcast1(Object value) { return (Integer)value; }     // checkcast
	static B       downcast2(I value)      { return       (B)value; }     // checkcast
	static D       downcast3(B value)      { return       (D)value; }     // checkcast

	static <T> T   identity(T value)       { return value; }           // no checkcast

	// due to type erasure (JVM does not support generics), all usages
	// of generic functions/methods require casts of output values
	static Integer passThrough(Integer value) { return identity(value); } // checkcast
	static String  passThrough(String  value) { return identity(value); } // checkcast

	public static void main(String[] args) {
		final var u1 = upcast1(1234);
		final var u2 = upcast2(new B());
		final var u3 = upcast3(new D());

		final var d1 = downcast1(1234);
		final var d2 = downcast2(new B());
		final var d3 = downcast3(new D());

		final var i1 = passThrough(1234);
		final var i2 = passThrough("ISEL");

		System.out.println(u1);
		System.out.println(u2);
		System.out.println(u3);

		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);

		System.out.println(i1);
		System.out.println(i2);
	}
}
