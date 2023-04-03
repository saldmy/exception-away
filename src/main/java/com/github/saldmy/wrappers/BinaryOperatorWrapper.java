package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingBinaryOperator;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.BinaryOperator;


public class BinaryOperatorWrapper {
    private static final MethodType BINARYOPERATOR_TYPE = MethodType.methodType(Object.class,
        Object.class, Object.class);

    @SuppressWarnings("unchecked")
    public static <T> BinaryOperator<T> wrap(ThrowingBinaryOperator<T, ? extends Throwable> binaryOperator) {
        try {
            MethodHandle factory = MainWrapper.createFactory(
                    ThrowingBinaryOperator.class, BinaryOperator.class, BINARYOPERATOR_TYPE, "apply"
            );
            return (BinaryOperator<T>) factory.invokeExact(binaryOperator);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

