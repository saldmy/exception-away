package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingSupplier;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.Supplier;


public class SupplierWrapper {
    private static final MethodType SUPPLIER_TYPE = MethodType.methodType(Object.class);

    @SuppressWarnings("unchecked")
    public static <T> Supplier<T> wrap(ThrowingSupplier<T, ? extends Throwable> supplier) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingSupplier.class, Supplier.class, SUPPLIER_TYPE, "get");
            return (Supplier<T>) factory.invokeExact(supplier);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}
