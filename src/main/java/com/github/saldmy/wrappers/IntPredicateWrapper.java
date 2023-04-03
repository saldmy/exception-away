package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingIntPredicate;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.IntPredicate;


public class IntPredicateWrapper {
    private static final MethodType INTPREDICATE_TYPE = MethodType.methodType(boolean.class, int.class);

    public static IntPredicate wrap(ThrowingIntPredicate<? extends Throwable> intPredicate) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingIntPredicate.class, IntPredicate.class,
                INTPREDICATE_TYPE, "test");
            return (IntPredicate) factory.invokeExact(intPredicate);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

