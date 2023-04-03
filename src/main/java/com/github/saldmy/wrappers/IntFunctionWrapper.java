package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingIntFunction;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.IntFunction;


public class IntFunctionWrapper {
    private static final MethodType INTFUNCTION_TYPE = MethodType.methodType(Object.class, int.class);

    @SuppressWarnings("unchecked")
    public static <R> IntFunction<R> wrap(ThrowingIntFunction<R, ? extends Throwable> intFunction) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingIntFunction.class, IntFunction.class,
                INTFUNCTION_TYPE, "apply");
            return (IntFunction<R>) factory.invokeExact(intFunction);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

