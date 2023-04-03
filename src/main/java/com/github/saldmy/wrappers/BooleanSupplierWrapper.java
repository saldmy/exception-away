package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingBooleanSupplier;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.BooleanSupplier;


public class BooleanSupplierWrapper {
    private static final MethodType BOOLEANSUPPLIER_TYPE = MethodType.methodType(boolean.class);

    public static BooleanSupplier wrap(ThrowingBooleanSupplier<? extends Throwable> booleanSupplier) {
        try {
            MethodHandle factory = MainWrapper.createFactory(
                    ThrowingBooleanSupplier.class, BooleanSupplier.class, BOOLEANSUPPLIER_TYPE, "getAsBoolean"
            );
            return (BooleanSupplier) factory.invokeExact(booleanSupplier);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

