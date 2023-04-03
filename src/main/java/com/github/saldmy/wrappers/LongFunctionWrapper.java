package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingLongFunction;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.LongFunction;


public class LongFunctionWrapper {
    private static final MethodType LONGFUNCTION_TYPE = MethodType.methodType(Object.class, long.class);

    @SuppressWarnings("unchecked")
    public static <R> LongFunction<R> wrap(ThrowingLongFunction<R, ? extends Throwable> longFunction) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingLongFunction.class, LongFunction.class,
                LONGFUNCTION_TYPE, "apply");
            return (LongFunction<R>) factory.invokeExact(longFunction);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

