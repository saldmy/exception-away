package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingLongToDoubleFunction;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.LongToDoubleFunction;


public class LongToDoubleFunctionWrapper {
    private static final MethodType LONGTODOUBLEFUNCTION_TYPE = MethodType.methodType(double.class, long.class);

    public static LongToDoubleFunction wrap(ThrowingLongToDoubleFunction<? extends Throwable> longToDoubleFunction) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingLongToDoubleFunction.class, LongToDoubleFunction.class,
                LONGTODOUBLEFUNCTION_TYPE, "applyAsDouble");
            return (LongToDoubleFunction) factory.invokeExact(longToDoubleFunction);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

