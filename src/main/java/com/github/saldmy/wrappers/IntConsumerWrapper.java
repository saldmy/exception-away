package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingIntConsumer;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.IntConsumer;


public class IntConsumerWrapper {
    private static final MethodType INTCONSUMER_TYPE = MethodType.methodType(void.class, int.class);

    public static IntConsumer wrap(ThrowingIntConsumer<? extends Throwable> intConsumer) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingIntConsumer.class, IntConsumer.class,
                INTCONSUMER_TYPE, "accept");
            return (IntConsumer) factory.invokeExact(intConsumer);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

