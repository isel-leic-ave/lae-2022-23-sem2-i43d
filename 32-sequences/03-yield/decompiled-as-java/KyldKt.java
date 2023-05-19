import kotlin.*;
import org.jetbrains.annotations.*;
import java.util.*;
import kotlin.jvm.functions.*;
import kotlin.coroutines.*;
import kotlin.sequences.*;

public final class KyldKt
{
    @NotNull
    private static final Sequence<Integer> seq;
    
    @NotNull
    public static final Sequence<Integer> getSeq() {
        return KyldKt.seq;
    }
    
    public static final void main() {
        final Iterator iterator = KyldKt.seq.iterator();
        while (iterator.hasNext()) {
            final int n = ((Number)iterator.next()).intValue();
            System.out.println(n);
        }
    }
    
    public static /* synthetic */ void main(final String[] args) {
        main();
    }
    
    static {
        seq = SequencesKt.sequence((Function2)new KyldKt$seq.KyldKt$seq$1((Continuation)null));
    }
}
