package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingDoubleFunction;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.DoubleFunction;


public class DoubleFunctionWrapper {
    private static final MethodType DOUBLEFUNCTION_TYPE = MethodType.methodType(Object.class, double.class);

    @SuppressWarnings("unchecked")
    public static <R> DoubleFunction<R> wrap(ThrowingDoubleFunction<R, ? extends Throwable> doubleFunction) {
        try {
            MethodHandle factory = MainWrapper.createFactory(
                    ThrowingDoubleFunction.class, DoubleFunction.class, DOUBLEFUNCTION_TYPE, "apply"
            );
            return (DoubleFunction<R>) factory.invokeExact(doubleFunction);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

