package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingObjIntConsumer;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.ObjIntConsumer;


public class ObjIntConsumerWrapper {
    private static final MethodType OBJINTCONSUMER_TYPE = MethodType.methodType(void.class, Object.class, int.class);

    @SuppressWarnings("unchecked")
    public static <T> ObjIntConsumer<T> wrap(ThrowingObjIntConsumer<T, ? extends Throwable> objIntConsumer) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingObjIntConsumer.class, ObjIntConsumer.class,
                OBJINTCONSUMER_TYPE, "accept");
            return (ObjIntConsumer<T>) factory.invokeExact(objIntConsumer);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

