package pt.isel.leic.lae.hello;

public class Hello {
	public static void main(String[] args) {
		final String name = args.length > 0 ? args[0] : "ISEL";
		System.out.println("Hello, " + name + "!");
	}
}
