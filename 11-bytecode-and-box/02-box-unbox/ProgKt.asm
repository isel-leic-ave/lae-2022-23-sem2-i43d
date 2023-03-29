Compiled from "prog.kt"
public final class ProgKt {
  public static final int sum(int, java.lang.Integer);
    Code:
       0: iload_0
       1: aload_1
       2: dup
       3: ifnonnull     11
       6: pop
       7: iconst_0
       8: goto          14
      11: invokevirtual #13                 // Method java/lang/Integer.intValue:()I
      14: iadd
      15: ireturn

  public static final java.lang.Integer xsum(int, java.lang.Integer);
    Code:
       0: aload_1
       1: ifnonnull     8
       4: aconst_null
       5: goto          17
       8: iload_0
       9: aload_1
      10: invokevirtual #13                 // Method java/lang/Integer.intValue:()I
      13: iadd
      14: invokestatic  #23                 // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
      17: areturn

  public static final void main();
    Code:
       0: getstatic     #31                 // Field java/lang/System.out:Ljava/io/PrintStream;
       3: iconst_3
       4: iconst_4
       5: invokestatic  #23                 // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
       8: invokestatic  #33                 // Method sum:(ILjava/lang/Integer;)I
      11: invokevirtual #39                 // Method java/io/PrintStream.println:(I)V
      14: getstatic     #31                 // Field java/lang/System.out:Ljava/io/PrintStream;
      17: bipush        8
      19: aconst_null
      20: invokestatic  #33                 // Method sum:(ILjava/lang/Integer;)I
      23: invokevirtual #39                 // Method java/io/PrintStream.println:(I)V
      26: getstatic     #31                 // Field java/lang/System.out:Ljava/io/PrintStream;
      29: iconst_3
      30: iconst_4
      31: invokestatic  #23                 // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
      34: invokestatic  #41                 // Method xsum:(ILjava/lang/Integer;)Ljava/lang/Integer;
      37: invokevirtual #44                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      40: getstatic     #31                 // Field java/lang/System.out:Ljava/io/PrintStream;
      43: bipush        8
      45: aconst_null
      46: invokestatic  #41                 // Method xsum:(ILjava/lang/Integer;)Ljava/lang/Integer;
      49: invokevirtual #44                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      52: return

  public static void main(java.lang.String[]);
    Code:
       0: invokestatic  #47                 // Method main:()V
       3: return
}
