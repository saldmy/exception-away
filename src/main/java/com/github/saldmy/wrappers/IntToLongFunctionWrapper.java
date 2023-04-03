package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingIntToLongFunction;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.IntToLongFunction;


public class IntToLongFunctionWrapper {
    private static final MethodType INTTOLONGFUNCTION_TYPE = MethodType.methodType(long.class, int.class);

    public static IntToLongFunction wrap(ThrowingIntToLongFunction<? extends Throwable> intToLongFunction) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingIntToLongFunction.class, IntToLongFunction.class,
                INTTOLONGFUNCTION_TYPE, "applyAsLong");
            return (IntToLongFunction) factory.invokeExact(intToLongFunction);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

