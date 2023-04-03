package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingDoubleConsumer;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.DoubleConsumer;


public class DoubleConsumerWrapper {
    private static final MethodType DOUBLECONSUMER_TYPE = MethodType.methodType(void.class, double.class);

    public static DoubleConsumer wrap(ThrowingDoubleConsumer<? extends Throwable> doubleConsumer) {
        try {
            MethodHandle factory = MainWrapper.createFactory(
                    ThrowingDoubleConsumer.class, DoubleConsumer.class, DOUBLECONSUMER_TYPE, "accept"
            );
            return (DoubleConsumer) factory.invokeExact(doubleConsumer);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

