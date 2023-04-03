package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingDoubleBinaryOperator;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.DoubleBinaryOperator;


public class DoubleBinaryOperatorWrapper {
    private static final MethodType DOUBLEBINARYOPERATOR_TYPE = MethodType.methodType(double.class,
        double.class, double.class);

    public static DoubleBinaryOperator wrap(ThrowingDoubleBinaryOperator<? extends Throwable> doubleBinaryOperator) {
        try {
            MethodHandle factory = MainWrapper.createFactory(
                    ThrowingDoubleBinaryOperator.class,
                    DoubleBinaryOperator.class,
                    DOUBLEBINARYOPERATOR_TYPE,
                    "applyAsDouble"
            );
            return (DoubleBinaryOperator) factory.invokeExact(doubleBinaryOperator);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

