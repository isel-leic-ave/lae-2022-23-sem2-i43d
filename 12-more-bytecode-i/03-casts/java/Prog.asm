Compiled from "Prog.java"
public class Prog {
  public Prog();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  static java.lang.Object upcast1(java.lang.Integer);
    Code:
       0: aload_0
       1: areturn

  static I upcast2(B);
    Code:
       0: aload_0
       1: areturn

  static B upcast3(D);
    Code:
       0: aload_0
       1: areturn

  static java.lang.Integer downcast1(java.lang.Object);
    Code:
       0: aload_0
       1: checkcast     #7                  // class java/lang/Integer
       4: areturn

  static B downcast2(I);
    Code:
       0: aload_0
       1: checkcast     #9                  // class B
       4: areturn

  static D downcast3(B);
    Code:
       0: aload_0
       1: checkcast     #11                 // class D
       4: areturn

  static <T> T identity(T);
    Code:
       0: aload_0
       1: areturn

  static java.lang.Integer passThrough(java.lang.Integer);
    Code:
       0: aload_0
       1: invokestatic  #13                 // Method identity:(Ljava/lang/Object;)Ljava/lang/Object;
       4: checkcast     #7                  // class java/lang/Integer
       7: areturn

  static java.lang.String passThrough(java.lang.String);
    Code:
       0: aload_0
       1: invokestatic  #13                 // Method identity:(Ljava/lang/Object;)Ljava/lang/Object;
       4: checkcast     #19                 // class java/lang/String
       7: areturn

  public static void main(java.lang.String[]);
    Code:
       0: sipush        1234
       3: invokestatic  #21                 // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
       6: invokestatic  #25                 // Method upcast1:(Ljava/lang/Integer;)Ljava/lang/Object;
       9: astore_1
      10: new           #9                  // class B
      13: dup
      14: invokespecial #29                 // Method B."<init>":()V
      17: invokestatic  #30                 // Method upcast2:(LB;)LI;
      20: astore_2
      21: new           #11                 // class D
      24: dup
      25: invokespecial #34                 // Method D."<init>":()V
      28: invokestatic  #35                 // Method upcast3:(LD;)LB;
      31: astore_3
      32: sipush        1234
      35: invokestatic  #21                 // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
      38: invokestatic  #39                 // Method downcast1:(Ljava/lang/Object;)Ljava/lang/Integer;
      41: astore        4
      43: new           #9                  // class B
      46: dup
      47: invokespecial #29                 // Method B."<init>":()V
      50: invokestatic  #43                 // Method downcast2:(LI;)LB;
      53: astore        5
      55: new           #11                 // class D
      58: dup
      59: invokespecial #34                 // Method D."<init>":()V
      62: invokestatic  #47                 // Method downcast3:(LB;)LD;
      65: astore        6
      67: sipush        1234
      70: invokestatic  #21                 // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
      73: invokestatic  #51                 // Method passThrough:(Ljava/lang/Integer;)Ljava/lang/Integer;
      76: astore        7
      78: ldc           #55                 // String ISEL
      80: invokestatic  #57                 // Method passThrough:(Ljava/lang/String;)Ljava/lang/String;
      83: astore        8
      85: getstatic     #60                 // Field java/lang/System.out:Ljava/io/PrintStream;
      88: aload_1
      89: invokevirtual #66                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      92: getstatic     #60                 // Field java/lang/System.out:Ljava/io/PrintStream;
      95: aload_2
      96: invokevirtual #66                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      99: getstatic     #60                 // Field java/lang/System.out:Ljava/io/PrintStream;
     102: aload_3
     103: invokevirtual #66                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
     106: getstatic     #60                 // Field java/lang/System.out:Ljava/io/PrintStream;
     109: aload         4
     111: invokevirtual #66                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
     114: getstatic     #60                 // Field java/lang/System.out:Ljava/io/PrintStream;
     117: aload         5
     119: invokevirtual #66                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
     122: getstatic     #60                 // Field java/lang/System.out:Ljava/io/PrintStream;
     125: aload         6
     127: invokevirtual #66                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
     130: getstatic     #60                 // Field java/lang/System.out:Ljava/io/PrintStream;
     133: aload         7
     135: invokevirtual #66                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
     138: getstatic     #60                 // Field java/lang/System.out:Ljava/io/PrintStream;
     141: aload         8
     143: invokevirtual #72                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     146: return
}
