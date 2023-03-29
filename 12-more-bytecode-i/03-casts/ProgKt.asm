Compiled from "prog.kt"
public final class ProgKt {
  private static final java.lang.Object upcast1(java.lang.Integer);
    Code:
       0: aload_0
       1: areturn

  private static final I upcast2(B);
    Code:
       0: aload_0
       1: checkcast     #12                 // class I
       4: areturn

  private static final B upcast3(D);
    Code:
       0: aload_0
       1: checkcast     #17                 // class B
       4: areturn

  private static final java.lang.Integer downcast1(java.lang.Object);
    Code:
       0: aload_0
       1: checkcast     #22                 // class java/lang/Integer
       4: areturn

  private static final B downcast2(I);
    Code:
       0: aload_0
       1: checkcast     #17                 // class B
       4: areturn

  private static final D downcast3(B);
    Code:
       0: aload_0
       1: checkcast     #30                 // class D
       4: areturn

  private static final <T> T identity(T);
    Code:
       0: aload_0
       1: areturn

  private static final java.lang.Integer passThrough(java.lang.Integer);
    Code:
       0: aload_0
       1: invokestatic  #37                 // Method identity:(Ljava/lang/Object;)Ljava/lang/Object;
       4: checkcast     #22                 // class java/lang/Integer
       7: areturn

  private static final java.lang.String passThrough(java.lang.String);
    Code:
       0: aload_0
       1: invokestatic  #37                 // Method identity:(Ljava/lang/Object;)Ljava/lang/Object;
       4: checkcast     #40                 // class java/lang/String
       7: areturn

  public static final void main();
    Code:
       0: sipush        1234
       3: invokestatic  #47                 // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
       6: invokestatic  #49                 // Method upcast1:(Ljava/lang/Integer;)Ljava/lang/Object;
       9: astore_0
      10: new           #17                 // class B
      13: dup
      14: invokespecial #52                 // Method B."<init>":()V
      17: invokestatic  #54                 // Method upcast2:(LB;)LI;
      20: astore_1
      21: new           #30                 // class D
      24: dup
      25: invokespecial #55                 // Method D."<init>":()V
      28: invokestatic  #57                 // Method upcast3:(LD;)LB;
      31: astore_2
      32: sipush        1234
      35: invokestatic  #47                 // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
      38: invokestatic  #59                 // Method downcast1:(Ljava/lang/Object;)Ljava/lang/Integer;
      41: astore_3
      42: new           #17                 // class B
      45: dup
      46: invokespecial #52                 // Method B."<init>":()V
      49: checkcast     #12                 // class I
      52: invokestatic  #61                 // Method downcast2:(LI;)LB;
      55: astore        4
      57: new           #30                 // class D
      60: dup
      61: invokespecial #55                 // Method D."<init>":()V
      64: checkcast     #17                 // class B
      67: invokestatic  #63                 // Method downcast3:(LB;)LD;
      70: astore        5
      72: sipush        1234
      75: invokestatic  #47                 // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
      78: invokestatic  #65                 // Method passThrough:(Ljava/lang/Integer;)Ljava/lang/Integer;
      81: astore        6
      83: ldc           #67                 // String ISEL
      85: invokestatic  #69                 // Method passThrough:(Ljava/lang/String;)Ljava/lang/String;
      88: astore        7
      90: getstatic     #75                 // Field java/lang/System.out:Ljava/io/PrintStream;
      93: aload_0
      94: invokevirtual #81                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      97: getstatic     #75                 // Field java/lang/System.out:Ljava/io/PrintStream;
     100: aload_1
     101: invokevirtual #81                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
     104: getstatic     #75                 // Field java/lang/System.out:Ljava/io/PrintStream;
     107: aload_2
     108: invokevirtual #81                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
     111: getstatic     #75                 // Field java/lang/System.out:Ljava/io/PrintStream;
     114: aload_3
     115: invokevirtual #81                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
     118: getstatic     #75                 // Field java/lang/System.out:Ljava/io/PrintStream;
     121: aload         4
     123: invokevirtual #81                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
     126: getstatic     #75                 // Field java/lang/System.out:Ljava/io/PrintStream;
     129: aload         5
     131: invokevirtual #81                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
     134: getstatic     #75                 // Field java/lang/System.out:Ljava/io/PrintStream;
     137: aload         6
     139: invokevirtual #81                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
     142: getstatic     #75                 // Field java/lang/System.out:Ljava/io/PrintStream;
     145: aload         7
     147: invokevirtual #81                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
     150: return

  public static void main(java.lang.String[]);
    Code:
       0: invokestatic  #92                 // Method main:()V
       3: return
}
