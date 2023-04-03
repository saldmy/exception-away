package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingObjLongConsumer;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.ObjLongConsumer;


public class ObjLongConsumerWrapper {
    private static final MethodType OBJLONGCONSUMER_TYPE = MethodType.methodType(void.class, Object.class, long.class);

    @SuppressWarnings("unchecked")
    public static <T> ObjLongConsumer<T> wrap(ThrowingObjLongConsumer<T, ? extends Throwable> objLongConsumer) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingObjLongConsumer.class, ObjLongConsumer.class,
                OBJLONGCONSUMER_TYPE, "accept");
            return (ObjLongConsumer<T>) factory.invokeExact(objLongConsumer);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

