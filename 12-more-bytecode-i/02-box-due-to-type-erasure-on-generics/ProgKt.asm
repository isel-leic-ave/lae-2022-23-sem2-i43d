Compiled from "prog.kt"
public final class ProgKt {
  public static final void main();
    Code:
       0: new           #8                  // class java/util/HashMap
       3: dup
       4: invokespecial #11                 // Method java/util/HashMap."<init>":()V
       7: astore_0
       8: aload_0
       9: sipush        1234
      12: invokestatic  #17                 // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
      15: ldc           #19                 // String Fernando Pessoa
      17: invokevirtual #23                 // Method java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      20: pop
      21: aload_0
      22: sipush        2345
      25: invokestatic  #17                 // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
      28: ldc           #25                 // String Afonso Henriques
      30: invokevirtual #23                 // Method java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      33: pop
      34: aload_0
      35: sipush        1234
      38: invokestatic  #17                 // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
      41: invokevirtual #29                 // Method java/util/HashMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
      44: checkcast     #31                 // class java/lang/String
      47: astore_1
      48: getstatic     #37                 // Field java/lang/System.out:Ljava/io/PrintStream;
      51: aload_1
      52: invokevirtual #43                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      55: return

  public static void main(java.lang.String[]);
    Code:
       0: invokestatic  #50                 // Method main:()V
       3: return
}
