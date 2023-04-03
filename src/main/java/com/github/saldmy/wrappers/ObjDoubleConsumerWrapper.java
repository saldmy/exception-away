package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingObjDoubleConsumer;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.ObjDoubleConsumer;


public class ObjDoubleConsumerWrapper {
    private static final MethodType OBJDOUBLECONSUMER_TYPE = MethodType.methodType(void.class,
        Object.class, double.class);

    @SuppressWarnings("unchecked")
    public static <T> ObjDoubleConsumer<T> wrap(ThrowingObjDoubleConsumer<T, ? extends Throwable> objDoubleConsumer) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingObjDoubleConsumer.class, ObjDoubleConsumer.class,
                OBJDOUBLECONSUMER_TYPE, "accept");
            return (ObjDoubleConsumer<T>) factory.invokeExact(objDoubleConsumer);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

