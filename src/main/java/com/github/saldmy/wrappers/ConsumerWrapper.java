package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingConsumer;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.Consumer;


public class ConsumerWrapper {
    private static final MethodType CONSUMER_TYPE = MethodType.methodType(void.class, Object.class);

    @SuppressWarnings("unchecked")
    public static <T> Consumer<T> wrap(ThrowingConsumer<T, ? extends Throwable> consumer) {
        try {
            MethodHandle factory = MainWrapper.createFactory(
                    ThrowingConsumer.class, Consumer.class, CONSUMER_TYPE, "accept"
            );
            return (Consumer<T>) factory.invokeExact(consumer);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}
