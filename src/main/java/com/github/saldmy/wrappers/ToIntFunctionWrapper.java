package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingToIntFunction;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.ToIntFunction;


public class ToIntFunctionWrapper {
    private static final MethodType TOINTFUNCTION_TYPE = MethodType.methodType(int.class, Object.class);

    @SuppressWarnings("unchecked")
    public static <T> ToIntFunction<T> wrap(ThrowingToIntFunction<T, ? extends Throwable> toIntFunction) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingToIntFunction.class, ToIntFunction.class,
                TOINTFUNCTION_TYPE, "applyAsInt");
            return (ToIntFunction<T>) factory.invokeExact(toIntFunction);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

