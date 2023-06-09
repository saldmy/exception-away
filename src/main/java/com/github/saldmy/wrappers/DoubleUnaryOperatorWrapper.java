package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingDoubleUnaryOperator;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.DoubleUnaryOperator;


public class DoubleUnaryOperatorWrapper {
    private static final MethodType DOUBLEUNARYOPERATOR_TYPE = MethodType.methodType(double.class, double.class);

    public static DoubleUnaryOperator wrap(ThrowingDoubleUnaryOperator<? extends Throwable> doubleUnaryOperator) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingDoubleUnaryOperator.class, DoubleUnaryOperator.class,
                DOUBLEUNARYOPERATOR_TYPE, "applyAsDouble");
            return (DoubleUnaryOperator) factory.invokeExact(doubleUnaryOperator);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

