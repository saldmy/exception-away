package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingPredicate;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.Predicate;


public class PredicateWrapper {
    private static final MethodType PREDICATE_TYPE = MethodType.methodType(boolean.class, Object.class);

    @SuppressWarnings("unchecked")
    public static <T> Predicate<T> wrap(ThrowingPredicate<T, ? extends Throwable> predicate) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingPredicate.class, Predicate.class, PREDICATE_TYPE, "test");
            return (Predicate<T>) factory.invokeExact(predicate);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}
