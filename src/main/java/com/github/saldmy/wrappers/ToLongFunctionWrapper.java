package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingToLongFunction;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.ToLongFunction;


public class ToLongFunctionWrapper {
    private static final MethodType TOLONGFUNCTION_TYPE = MethodType.methodType(long.class, Object.class);

    @SuppressWarnings("unchecked")
    public static <T> ToLongFunction<T> wrap(ThrowingToLongFunction<T, ? extends Throwable> toLongFunction) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingToLongFunction.class, ToLongFunction.class,
                TOLONGFUNCTION_TYPE, "applyAsLong");
            return (ToLongFunction<T>) factory.invokeExact(toLongFunction);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

