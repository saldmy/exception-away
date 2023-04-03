package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingFunction;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.Function;


public class FunctionWrapper {
    private static final MethodType FUNCTION_TYPE = MethodType.methodType(Object.class, Object.class);

    @SuppressWarnings("unchecked")
    public static <T, R> Function<T, R> wrap(ThrowingFunction<T, R, ? extends Throwable> function) {
        try {
            MethodHandle factory = MainWrapper.createFactory(
                    ThrowingFunction.class, Function.class, FUNCTION_TYPE, "apply"
            );
            return (Function<T, R>) factory.invokeExact(function);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}
