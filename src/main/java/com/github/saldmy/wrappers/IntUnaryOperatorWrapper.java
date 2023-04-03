package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingIntUnaryOperator;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.IntUnaryOperator;


public class IntUnaryOperatorWrapper {
    private static final MethodType INTUNARYOPERATOR_TYPE = MethodType.methodType(int.class, int.class);

    public static IntUnaryOperator wrap(ThrowingIntUnaryOperator<? extends Throwable> intUnaryOperator) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingIntUnaryOperator.class, IntUnaryOperator.class,
                INTUNARYOPERATOR_TYPE, "applyAsInt");
            return (IntUnaryOperator) factory.invokeExact(intUnaryOperator);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

