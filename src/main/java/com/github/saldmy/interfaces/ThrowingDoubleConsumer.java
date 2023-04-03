package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingDoubleConsumer<E extends Throwable> {
    void accept(double value) throws E;
}
