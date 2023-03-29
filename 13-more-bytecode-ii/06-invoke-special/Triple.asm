Compiled from "prog.kt"
public final class Triple extends Pair {
  private final int c;

  public Triple(int, int, int);
    Code:
       0: aload_0
       1: iload_1
       2: iload_2
       3: invokespecial #9                  // Method Pair."<init>":(II)V
       6: aload_0
       7: iload_3
       8: putfield      #13                 // Field c:I
      11: return

  public final int getC();
    Code:
       0: aload_0
       1: getfield      #13                 // Field c:I
       4: ireturn

  public void show();
    Code:
       0: aload_0
       1: invokespecial #23                 // Method Pair.show:()V
       4: getstatic     #29                 // Field java/lang/System.out:Ljava/io/PrintStream;
       7: new           #31                 // class java/lang/StringBuilder
      10: dup
      11: invokespecial #33                 // Method java/lang/StringBuilder."<init>":()V
      14: ldc           #35                 // String c:
      16: invokevirtual #39                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      19: aload_0
      20: getfield      #13                 // Field c:I
      23: invokevirtual #42                 // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
      26: ldc           #44                 // String ;
      28: invokevirtual #39                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      31: invokevirtual #48                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      34: invokevirtual #54                 // Method java/io/PrintStream.print:(Ljava/lang/Object;)V
      37: return
}
