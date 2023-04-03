package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingToIntBiFunction;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.ToIntBiFunction;


public class ToIntBiFunctionWrapper {
    private static final MethodType TOINTBIFUNCTION_TYPE = MethodType.methodType(int.class,
        Object.class, Object.class);

    @SuppressWarnings("unchecked")
    public static <T, U> ToIntBiFunction<T, U> wrap(ThrowingToIntBiFunction<T, U, ? extends Throwable> toIntBiFunction) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingToIntBiFunction.class, ToIntBiFunction.class,
                TOINTBIFUNCTION_TYPE, "applyAsInt");
            return (ToIntBiFunction<T, U>) factory.invokeExact(toIntBiFunction);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

