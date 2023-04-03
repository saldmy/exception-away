package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingLongSupplier;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.LongSupplier;


public class LongSupplierWrapper {
    private static final MethodType LONGSUPPLIER_TYPE = MethodType.methodType(long.class);

    public static LongSupplier wrap(ThrowingLongSupplier<? extends Throwable> longSupplier) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingLongSupplier.class, LongSupplier.class,
                LONGSUPPLIER_TYPE, "getAsLong");
            return (LongSupplier) factory.invokeExact(longSupplier);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

