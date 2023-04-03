package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingDoubleToLongFunction;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.DoubleToLongFunction;


public class DoubleToLongFunctionWrapper {
    private static final MethodType DOUBLETOLONGFUNCTION_TYPE = MethodType.methodType(long.class, double.class);

    public static DoubleToLongFunction wrap(ThrowingDoubleToLongFunction<? extends Throwable> doubleToLongFunction) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingDoubleToLongFunction.class, DoubleToLongFunction.class,
                DOUBLETOLONGFUNCTION_TYPE, "applyAsLong");
            return (DoubleToLongFunction) factory.invokeExact(doubleToLongFunction);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

