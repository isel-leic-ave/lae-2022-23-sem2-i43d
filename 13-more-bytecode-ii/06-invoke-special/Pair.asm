Compiled from "prog.kt"
public class Pair {
  private final int a;

  private final int b;

  public Pair(int, int);
    Code:
       0: aload_0
       1: invokespecial #9                  // Method java/lang/Object."<init>":()V
       4: aload_0
       5: iload_1
       6: putfield      #13                 // Field a:I
       9: aload_0
      10: iload_2
      11: putfield      #16                 // Field b:I
      14: return

  public final int getA();
    Code:
       0: aload_0
       1: getfield      #13                 // Field a:I
       4: ireturn

  public final int getB();
    Code:
       0: aload_0
       1: getfield      #16                 // Field b:I
       4: ireturn

  public void show();
    Code:
       0: getstatic     #28                 // Field java/lang/System.out:Ljava/io/PrintStream;
       3: new           #30                 // class java/lang/StringBuilder
       6: dup
       7: invokespecial #31                 // Method java/lang/StringBuilder."<init>":()V
      10: ldc           #33                 // String a:
      12: invokevirtual #37                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      15: aload_0
      16: getfield      #13                 // Field a:I
      19: invokevirtual #40                 // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
      22: ldc           #42                 // String ; b:
      24: invokevirtual #37                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      27: aload_0
      28: getfield      #16                 // Field b:I
      31: invokevirtual #40                 // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
      34: ldc           #44                 // String ;
      36: invokevirtual #37                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      39: invokevirtual #48                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      42: invokevirtual #54                 // Method java/io/PrintStream.print:(Ljava/lang/Object;)V
      45: return
}
