package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingCallable;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.concurrent.Callable;


public class CallableWrapper {
    private static final MethodType CALLABLE_TYPE = MethodType.methodType(Object.class);

    @SuppressWarnings("unchecked")
    public static <V> Callable<V> wrap(ThrowingCallable<V, ? extends Throwable> callable) {
        try {
            MethodHandle factory = MainWrapper.createFactory(
                    ThrowingCallable.class, Callable.class, CALLABLE_TYPE, "call"
            );
            return (Callable<V>) factory.invokeExact(callable);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}
