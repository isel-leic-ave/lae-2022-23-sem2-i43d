Compiled from "prog.kt"
public final class ProgKt {
  private static final java.lang.String msg;

  public static final java.lang.String getMsg();
    Code:
       0: getstatic     #11                 // Field msg:Ljava/lang/String;
       3: areturn

  public static final void showMsg();
    Code:
       0: getstatic     #19                 // Field java/lang/System.out:Ljava/io/PrintStream;
       3: getstatic     #11                 // Field msg:Ljava/lang/String;
       6: invokevirtual #25                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
       9: return

  public static final void main();
    Code:
       0: invokestatic  #28                 // Method showMsg:()V
       3: return

  public static void main(java.lang.String[]);
    Code:
       0: invokestatic  #31                 // Method main:()V
       3: return

  static {};
    Code:
       0: ldc           #36                 // String Hello, world!
       2: putstatic     #11                 // Field msg:Ljava/lang/String;
       5: return
}
