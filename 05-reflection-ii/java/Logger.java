public class Logger {
	public static void log(Object obj) throws Exception {
		if (obj == null) {
			System.out.println("null");
		} else {
		
			final var klass = obj.getClass();
			
			System.out.printf("%s {\n", klass.getSimpleName());
			for (final var method : klass.getMethods()) {
				if (method.getName().startsWith("get") &&
						!method.getName().equals("getClass") &&
				    method.getParameterCount() == 0) {
					final var propName = method.getName().substring(3);
					System.out.printf("  %s : %s\n", propName, method.invoke(obj));
				}
			}
			System.out.println("}");
		}
	}
}
