Compiled from "prog.kt"
public final class ProgKt {
  public static final kotlin.jvm.functions.Function0<java.lang.String> createMessenger(java.lang.String);
    Code:
       0: aload_0
       1: ldc           #10                 // String msg
       3: invokestatic  #16                 // Method kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
       6: new           #18                 // class java/lang/StringBuilder
       9: dup
      10: invokespecial #22                 // Method java/lang/StringBuilder."<init>":()V
      13: ldc           #24                 // String extra(
      15: invokevirtual #28                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      18: aload_0
      19: invokevirtual #28                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      22: bipush        41
      24: invokevirtual #31                 // Method java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
      27: invokevirtual #35                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      30: astore_1
      31: new           #37                 // class ProgKt$createMessenger$theMessenger$1
      34: dup
      35: aload_0
      36: aload_1
      37: invokespecial #40                 // Method ProgKt$createMessenger$theMessenger$1."<init>":(Ljava/lang/String;Ljava/lang/String;)V
      40: checkcast     #42                 // class kotlin/jvm/functions/Function0
      43: astore_2
      44: getstatic     #48                 // Field java/lang/System.out:Ljava/io/PrintStream;
      47: new           #18                 // class java/lang/StringBuilder
      50: dup
      51: invokespecial #22                 // Method java/lang/StringBuilder."<init>":()V
      54: ldc           #50                 // String >> argument msg (\"
      56: invokevirtual #28                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      59: aload_0
      60: invokevirtual #28                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      63: ldc           #52                 // String \") and local extra about to become invalid
      65: invokevirtual #28                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      68: invokevirtual #35                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      71: invokevirtual #58                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      74: aload_2
      75: areturn

  public static final void main();
    Code:
       0: ldc           #65                 // String Hello, LAE!
       2: invokestatic  #67                 // Method createMessenger:(Ljava/lang/String;)Lkotlin/jvm/functions/Function0;
       5: astore_0
       6: ldc           #69                 // String Hello, LEIC43D!
       8: invokestatic  #67                 // Method createMessenger:(Ljava/lang/String;)Lkotlin/jvm/functions/Function0;
      11: astore_1
      12: ldc           #71                 // String \n:: messengers created ::\n
      14: astore_2
      15: getstatic     #48                 // Field java/lang/System.out:Ljava/io/PrintStream;
      18: aload_2
      19: invokevirtual #58                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      22: aload_0
      23: invokeinterface #75,  1           // InterfaceMethod kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
      28: checkcast     #77                 // class java/lang/String
      31: astore_2
      32: aload_1
      33: invokeinterface #75,  1           // InterfaceMethod kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
      38: checkcast     #77                 // class java/lang/String
      41: astore_3
      42: ldc           #79                 // String \n:: messages produced ::\n
      44: astore        4
      46: getstatic     #48                 // Field java/lang/System.out:Ljava/io/PrintStream;
      49: aload         4
      51: invokevirtual #58                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      54: getstatic     #48                 // Field java/lang/System.out:Ljava/io/PrintStream;
      57: aload_2
      58: invokevirtual #58                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      61: getstatic     #48                 // Field java/lang/System.out:Ljava/io/PrintStream;
      64: aload_3
      65: invokevirtual #58                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      68: return

  public static void main(java.lang.String[]);
    Code:
       0: invokestatic  #86                 // Method main:()V
       3: return
}
