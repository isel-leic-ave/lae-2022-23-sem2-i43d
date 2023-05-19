import kotlin.jvm.functions.*;
import kotlin.sequences.*;
import kotlin.coroutines.*;
import kotlin.coroutines.intrinsics.*;
import kotlin.*;
import kotlin.coroutines.jvm.internal.*;
import org.jetbrains.annotations.*;

static final class KyldKt$seq$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Integer>, Continuation<? super Unit>, Object> {
    int label;
    private /* synthetic */ Object L$0;
    
    KyldKt$seq$1(final Continuation<? super KyldKt$seq$1> $completion) {
        super(2, (Continuation)$completion);
    }
    
    @Nullable
    public final Object invokeSuspend(@NotNull final Object $result) {
        final Object coroutine_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        SequenceScope $this$sequence = null;
        Label_0198: {
            Label_0145: {
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure($result);
                        final SequenceScope sequenceScope;
                        $this$sequence = (sequenceScope = (SequenceScope)this.L$0);
                        final Integer boxInt = Boxing.boxInt(1734);
                        final Continuation continuation = (Continuation)this;
                        this.L$0 = $this$sequence;
                        this.label = 1;
                        if (sequenceScope.yield((Object)boxInt, continuation) == coroutine_SUSPENDED) {
                            return coroutine_SUSPENDED;
                        }
                        break;
                    }
                    case 1: {
                        $this$sequence = (SequenceScope)this.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    }
                    case 2: {
                        $this$sequence = (SequenceScope)this.L$0;
                        ResultKt.throwOnFailure($result);
                        break Label_0145;
                    }
                    case 3: {
                        $this$sequence = (SequenceScope)this.L$0;
                        ResultKt.throwOnFailure($result);
                        break Label_0198;
                    }
                    case 4: {
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    }
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
                final SequenceScope sequenceScope2 = $this$sequence;
                final Integer boxInt2 = Boxing.boxInt(2122);
                final Continuation continuation2 = (Continuation)this;
                this.L$0 = $this$sequence;
                this.label = 2;
                if (sequenceScope2.yield((Object)boxInt2, continuation2) == coroutine_SUSPENDED) {
                    return coroutine_SUSPENDED;
                }
            }
            System.out.println((Object)"meio");
            final SequenceScope sequenceScope3 = $this$sequence;
            final Integer boxInt3 = Boxing.boxInt(3897);
            final Continuation continuation3 = (Continuation)this;
            this.L$0 = $this$sequence;
            this.label = 3;
            if (sequenceScope3.yield((Object)boxInt3, continuation3) == coroutine_SUSPENDED) {
                return coroutine_SUSPENDED;
            }
        }
        final SequenceScope sequenceScope4 = $this$sequence;
        final Integer boxInt4 = Boxing.boxInt(4234);
        final Continuation continuation4 = (Continuation)this;
        this.L$0 = null;
        this.label = 4;
        if (sequenceScope4.yield((Object)boxInt4, continuation4) == coroutine_SUSPENDED) {
            return coroutine_SUSPENDED;
        }
        return Unit.INSTANCE;
    }
    
    @NotNull
    public final Continuation<Unit> create(@Nullable final Object value, @NotNull final Continuation<?> $completion) {
        final KyldKt$seq$1 kyldKt$seq$1 = new KyldKt$seq$1((Continuation)$completion);
        kyldKt$seq$1.L$0 = value;
        return (Continuation<Unit>)kyldKt$seq$1;
    }
    
    @Nullable
    public final Object invoke(@NotNull final SequenceScope<? super Integer> p1, @Nullable final Continuation<? super Unit> p2) {
        return ((KyldKt$seq$1)this.create((Object)p1, (Continuation)p2)).invokeSuspend((Object)Unit.INSTANCE);
    }
    
    public /* bridge */ Object invoke(final Object p1, final Object p2) {
        return this.invoke((SequenceScope)p1, (Continuation)p2);
    }
}
