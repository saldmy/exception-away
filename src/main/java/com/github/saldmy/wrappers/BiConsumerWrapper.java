package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingBiConsumer;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.BiConsumer;


public class BiConsumerWrapper {
    private static final MethodType BICONSUMER_TYPE = MethodType.methodType(void.class, Object.class, Object.class);

    @SuppressWarnings("unchecked")
    public static <T, U> BiConsumer<T, U> wrap(ThrowingBiConsumer<T, U, ? extends Throwable> biConsumer) {
        try {
            MethodHandle factory = MainWrapper.createFactory(
                    ThrowingBiConsumer.class, BiConsumer.class, BICONSUMER_TYPE, "accept"
            );
            return (BiConsumer<T, U>) factory.invokeExact(biConsumer);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}

