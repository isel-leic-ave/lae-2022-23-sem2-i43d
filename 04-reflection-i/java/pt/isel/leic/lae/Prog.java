package pt.isel.leic.lae;

public class Prog {
	public static void inspect(Object obj) throws Exception {
		System.out.println("--------");
		
		final var cls = obj.getClass();
		
		System.out.println("inspector : " + cls.getClass().getSimpleName());
		System.out.println("full  name: " + cls.getCanonicalName());
		System.out.println("short name: " + cls.getSimpleName());

		System.out.println("--------");
		System.out.println("methods: [");
		for (var m : cls.getDeclaredMethods()) {
			System.out.println("   " + m);  // show all members of obj's type
			if (m.getName().equals("mcwp")) {
				System.out.print("      >>>   ");
				m.invoke(obj);
			}
		}
		System.out.println("]");
	}

	public static void main(String[] args) throws Exception {
		System.out.println("--------");

		final var cls = ClassWithProperties.class;
		
		System.out.println("inspector : " + cls.getClass().getSimpleName());
		System.out.println("full  name: " + cls.getCanonicalName());
		System.out.println("short name: " + cls.getSimpleName());
		
		final var obj = new ClassWithProperties(10, "LAE", 1.2345);
		
		inspect(obj);
		
		final var str = "ISEL - LEIC - LAE";
		
		inspect(str);
		
	}
}
