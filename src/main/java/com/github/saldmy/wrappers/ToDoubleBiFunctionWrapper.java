package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingToDoubleBiFunction;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.ToDoubleBiFunction;


public class ToDoubleBiFunctionWrapper {
    private static final MethodType TODOUBLEBIFUNCTION_TYPE = MethodType.methodType(double.class,
        Object.class, Object.class);

    @SuppressWarnings("unchecked")
    public static <T, U> ToDoubleBiFunction<T, U> wrap(ThrowingToDoubleBiFunction<T, U, ? extends Throwable> toDoubleBiFunction) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingToDoubleBiFunction.class, ToDoubleBiFunction.class,
                TODOUBLEBIFUNCTION_TYPE, "applyAsDouble");
            return (ToDoubleBiFunction<T, U>) factory.invokeExact(toDoubleBiFunction);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

