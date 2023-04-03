package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingDoubleToIntFunction;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.DoubleToIntFunction;


public class DoubleToIntFunctionWrapper {
    private static final MethodType DOUBLETOINTFUNCTION_TYPE = MethodType.methodType(int.class, double.class);

    public static DoubleToIntFunction wrap(ThrowingDoubleToIntFunction<? extends Throwable> doubleToIntFunction) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingDoubleToIntFunction.class, DoubleToIntFunction.class,
                DOUBLETOINTFUNCTION_TYPE, "applyAsInt");
            return (DoubleToIntFunction) factory.invokeExact(doubleToIntFunction);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

