package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingDoubleSupplier;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.DoubleSupplier;


public class DoubleSupplierWrapper {
    private static final MethodType DOUBLESUPPLIER_TYPE = MethodType.methodType(double.class);

    public static DoubleSupplier wrap(ThrowingDoubleSupplier<? extends Throwable> doubleSupplier) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingDoubleSupplier.class, DoubleSupplier.class,
                DOUBLESUPPLIER_TYPE, "getAsDouble");
            return (DoubleSupplier) factory.invokeExact(doubleSupplier);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

