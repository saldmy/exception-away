package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingBiPredicate;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.BiPredicate;


public class BiPredicateWrapper {
    private static final MethodType BIPREDICATE_TYPE = MethodType.methodType(boolean.class, Object.class, Object.class);

    @SuppressWarnings("unchecked")
    public static <T, U> BiPredicate<T, U> wrap(ThrowingBiPredicate<T, U, ? extends Throwable> biPredicate) {
        try {
            MethodHandle factory = MainWrapper.createFactory(
                    ThrowingBiPredicate.class, BiPredicate.class, BIPREDICATE_TYPE, "test"
            );
            return (BiPredicate<T, U>) factory.invokeExact(biPredicate);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

