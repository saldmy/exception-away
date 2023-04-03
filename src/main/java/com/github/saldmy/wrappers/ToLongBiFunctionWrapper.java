package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingToLongBiFunction;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.ToLongBiFunction;


public class ToLongBiFunctionWrapper {
    private static final MethodType TOLONGBIFUNCTION_TYPE = MethodType.methodType(long.class,
        Object.class, Object.class);

    @SuppressWarnings("unchecked")
    public static <T, U> ToLongBiFunction<T, U> wrap(ThrowingToLongBiFunction<T, U, ? extends Throwable> toLongBiFunction) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingToLongBiFunction.class, ToLongBiFunction.class,
                TOLONGBIFUNCTION_TYPE, "applyAsLong");
            return (ToLongBiFunction<T, U>) factory.invokeExact(toLongBiFunction);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

