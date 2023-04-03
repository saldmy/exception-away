package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingLongConsumer;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.LongConsumer;


public class LongConsumerWrapper {
    private static final MethodType LONGCONSUMER_TYPE = MethodType.methodType(void.class, long.class);

    public static LongConsumer wrap(ThrowingLongConsumer<? extends Throwable> longConsumer) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingLongConsumer.class, LongConsumer.class,
                LONGCONSUMER_TYPE, "accept");
            return (LongConsumer) factory.invokeExact(longConsumer);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

