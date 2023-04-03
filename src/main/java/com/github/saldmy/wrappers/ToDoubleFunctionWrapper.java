package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingToDoubleFunction;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.ToDoubleFunction;


public class ToDoubleFunctionWrapper {
    private static final MethodType TODOUBLEFUNCTION_TYPE = MethodType.methodType(double.class, Object.class);

    @SuppressWarnings("unchecked")
    public static <T> ToDoubleFunction<T> wrap(ThrowingToDoubleFunction<T, ? extends Throwable> toDoubleFunction) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingToDoubleFunction.class, ToDoubleFunction.class,
                TODOUBLEFUNCTION_TYPE, "applyAsDouble");
            return (ToDoubleFunction<T>) factory.invokeExact(toDoubleFunction);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

