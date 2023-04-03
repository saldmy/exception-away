package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingBiFunction;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.BiFunction;


public class BiFunctionWrapper {
    private static final MethodType BIFUNCTION_TYPE = MethodType.methodType(Object.class, Object.class, Object.class);

    @SuppressWarnings("unchecked")
    public static <T, U, R> BiFunction<T, U, R> wrap(ThrowingBiFunction<T, U, R, ? extends Throwable> biFunction) {
        try {
            MethodHandle factory = MainWrapper.createFactory(
                    ThrowingBiFunction.class, BiFunction.class, BIFUNCTION_TYPE, "apply"
            );
            return (BiFunction<T, U, R>) factory.invokeExact(biFunction);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

