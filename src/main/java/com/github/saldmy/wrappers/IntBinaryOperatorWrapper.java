package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingIntBinaryOperator;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.IntBinaryOperator;


public class IntBinaryOperatorWrapper {
    private static final MethodType INTBINARYOPERATOR_TYPE = MethodType.methodType(int.class, int.class, int.class);

    public static IntBinaryOperator wrap(ThrowingIntBinaryOperator<? extends Throwable> intBinaryOperator) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingIntBinaryOperator.class, IntBinaryOperator.class,
                INTBINARYOPERATOR_TYPE, "applyAsInt");
            return (IntBinaryOperator) factory.invokeExact(intBinaryOperator);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

