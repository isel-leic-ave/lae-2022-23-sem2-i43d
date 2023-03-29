Compiled from "prog.kt"
public final class ProgKt {
  public static final int foo(int, int);
    Code:
       0: iconst_0
       1: istore_2
       2: iload_2
       3: iload_0
       4: iadd
       5: istore_2
       6: iload_2
       7: iload_1
       8: iadd
       9: istore_2
      10: iload_2
      11: ireturn

  public static final java.lang.String or(java.lang.String, java.lang.String);
    Code:
       0: aload_1
       1: ldc           #16                 // String alt
       3: invokestatic  #22                 // Method kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
       6: aload_0
       7: dup
       8: ifnonnull     13
      11: pop
      12: aload_1
      13: areturn

  public static final void main();
    Code:
       0: getstatic     #34                 // Field java/lang/System.out:Ljava/io/PrintStream;
       3: iconst_3
       4: iconst_4
       5: invokestatic  #36                 // Method foo:(II)I
       8: invokevirtual #42                 // Method java/io/PrintStream.println:(I)V
      11: getstatic     #34                 // Field java/lang/System.out:Ljava/io/PrintStream;
      14: iconst_5
      15: bipush        6
      17: invokestatic  #36                 // Method foo:(II)I
      20: invokevirtual #42                 // Method java/io/PrintStream.println:(I)V
      23: aconst_null
      24: astore_0
      25: getstatic     #34                 // Field java/lang/System.out:Ljava/io/PrintStream;
      28: aload_0
      29: ldc           #44                 // String ISEL
      31: invokestatic  #46                 // Method or:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      34: invokevirtual #49                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      37: return

  public static void main(java.lang.String[]);
    Code:
       0: invokestatic  #53                 // Method main:()V
       3: return
}
