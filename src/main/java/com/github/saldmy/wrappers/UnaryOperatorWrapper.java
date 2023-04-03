package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingUnaryOperator;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.UnaryOperator;


public class UnaryOperatorWrapper {
    private static final MethodType UNARYOPERATOR_TYPE = MethodType.methodType(Object.class, Object.class);

    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> wrap(ThrowingUnaryOperator<T, ? extends Throwable> unaryOperator) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingUnaryOperator.class, UnaryOperator.class,
                UNARYOPERATOR_TYPE, "apply");
            return (UnaryOperator<T>) factory.invokeExact(unaryOperator);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

