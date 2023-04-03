package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingLongToIntFunction;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.LongToIntFunction;


public class LongToIntFunctionWrapper {
    private static final MethodType LONGTOINTFUNCTION_TYPE = MethodType.methodType(int.class, long.class);

    public static LongToIntFunction wrap(ThrowingLongToIntFunction<? extends Throwable> longToIntFunction) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingLongToIntFunction.class, LongToIntFunction.class,
                LONGTOINTFUNCTION_TYPE, "applyAsInt");
            return (LongToIntFunction) factory.invokeExact(longToIntFunction);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

