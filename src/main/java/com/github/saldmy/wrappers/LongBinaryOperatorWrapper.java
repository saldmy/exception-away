package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingLongBinaryOperator;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.LongBinaryOperator;


public class LongBinaryOperatorWrapper {
    private static final MethodType LONGBINARYOPERATOR_TYPE = MethodType.methodType(long.class, long.class, long.class);

    public static LongBinaryOperator wrap(ThrowingLongBinaryOperator<? extends Throwable> longBinaryOperator) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingLongBinaryOperator.class, LongBinaryOperator.class,
                LONGBINARYOPERATOR_TYPE, "applyAsLong");
            return (LongBinaryOperator) factory.invokeExact(longBinaryOperator);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

