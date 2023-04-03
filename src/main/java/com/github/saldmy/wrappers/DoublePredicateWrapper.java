package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingDoublePredicate;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.DoublePredicate;


public class DoublePredicateWrapper {
    private static final MethodType DOUBLEPREDICATE_TYPE = MethodType.methodType(boolean.class, double.class);

    public static DoublePredicate wrap(ThrowingDoublePredicate<? extends Throwable> doublePredicate) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingDoublePredicate.class, DoublePredicate.class,
                DOUBLEPREDICATE_TYPE, "test");
            return (DoublePredicate) factory.invokeExact(doublePredicate);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

