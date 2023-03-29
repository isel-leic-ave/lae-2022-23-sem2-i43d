Compiled from "prog.kt"
final class ProgKt$createMessenger$theMessenger$1 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function0<java.lang.String> {
  final java.lang.String $msg;

  final java.lang.String $extra;

  ProgKt$createMessenger$theMessenger$1(java.lang.String, java.lang.String);
    Code:
       0: aload_0
       1: aload_1
       2: putfield      #13                 // Field $msg:Ljava/lang/String;
       5: aload_0
       6: aload_2
       7: putfield      #16                 // Field $extra:Ljava/lang/String;
      10: aload_0
      11: iconst_0
      12: invokespecial #19                 // Method kotlin/jvm/internal/Lambda."<init>":(I)V
      15: return

  public final java.lang.String invoke();
    Code:
       0: getstatic     #30                 // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #32                 // String >> using argument msg and local extra:
       5: invokevirtual #38                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
       8: getstatic     #30                 // Field java/lang/System.out:Ljava/io/PrintStream;
      11: aload_0
      12: getfield      #13                 // Field $msg:Ljava/lang/String;
      15: invokevirtual #38                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      18: getstatic     #30                 // Field java/lang/System.out:Ljava/io/PrintStream;
      21: aload_0
      22: getfield      #16                 // Field $extra:Ljava/lang/String;
      25: invokevirtual #38                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      28: aload_0
      29: getfield      #13                 // Field $msg:Ljava/lang/String;
      32: areturn

  public java.lang.Object invoke();
    Code:
       0: aload_0
       1: invokevirtual #41                 // Method invoke:()Ljava/lang/String;
       4: areturn
}
