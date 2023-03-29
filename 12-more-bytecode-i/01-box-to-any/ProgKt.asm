Compiled from "prog.kt"
public final class ProgKt {
  public static final void main();
    Code:
       0: ldc           #8                  // String ISEL
       2: sipush        2023
       5: invokestatic  #14                 // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
       8: invokestatic  #18                 // Method display:(Ljava/lang/String;Ljava/lang/Object;)V
      11: ldc           #20                 // String LAE
      13: ldc           #22                 // String LEIC43D
      15: invokestatic  #18                 // Method display:(Ljava/lang/String;Ljava/lang/Object;)V
      18: return

  public static final void display(java.lang.String, java.lang.Object);
    Code:
       0: aload_0
       1: ldc           #26                 // String name
       3: invokestatic  #32                 // Method kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
       6: getstatic     #38                 // Field java/lang/System.out:Ljava/io/PrintStream;
       9: new           #40                 // class java/lang/StringBuilder
      12: dup
      13: invokespecial #43                 // Method java/lang/StringBuilder."<init>":()V
      16: aload_0
      17: invokevirtual #47                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      20: ldc           #49                 // String :
      22: invokevirtual #47                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      25: aload_1
      26: invokevirtual #52                 // Method java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      29: invokevirtual #56                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      32: invokevirtual #62                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      35: return

  public static void main(java.lang.String[]);
    Code:
       0: invokestatic  #68                 // Method main:()V
       3: return
}
