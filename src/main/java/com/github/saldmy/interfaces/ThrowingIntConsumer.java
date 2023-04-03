package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingIntConsumer<E extends Throwable> {
    void accept(int value) throws E;
}
