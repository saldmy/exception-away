package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingLongPredicate;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.LongPredicate;


public class LongPredicateWrapper {
    private static final MethodType LONGPREDICATE_TYPE = MethodType.methodType(boolean.class, long.class);

    public static LongPredicate wrap(ThrowingLongPredicate<? extends Throwable> longPredicate) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingLongPredicate.class, LongPredicate.class,
                LONGPREDICATE_TYPE, "test");
            return (LongPredicate) factory.invokeExact(longPredicate);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

