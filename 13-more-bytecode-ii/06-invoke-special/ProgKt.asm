Compiled from "prog.kt"
public final class ProgKt {
  public static final void showPairOrTriple(Pair);
    Code:
       0: aload_0
       1: ldc           #9                  // String obj
       3: invokestatic  #15                 // Method kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
       6: aload_0
       7: invokevirtual #21                 // Method Pair.show:()V
      10: getstatic     #27                 // Field java/lang/System.out:Ljava/io/PrintStream;
      13: invokevirtual #32                 // Method java/io/PrintStream.println:()V
      16: return

  public static final void main();
    Code:
       0: new           #17                 // class Pair
       3: dup
       4: iconst_2
       5: iconst_3
       6: invokespecial #38                 // Method Pair."<init>":(II)V
       9: astore_0
      10: new           #40                 // class Triple
      13: dup
      14: iconst_4
      15: iconst_5
      16: bipush        6
      18: invokespecial #43                 // Method Triple."<init>":(III)V
      21: astore_1
      22: aload_0
      23: invokestatic  #45                 // Method showPairOrTriple:(LPair;)V
      26: aload_1
      27: checkcast     #17                 // class Pair
      30: invokestatic  #45                 // Method showPairOrTriple:(LPair;)V
      33: return

  public static void main(java.lang.String[]);
    Code:
       0: invokestatic  #51                 // Method main:()V
       3: return
}
