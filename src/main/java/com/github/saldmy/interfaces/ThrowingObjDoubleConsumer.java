package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingObjDoubleConsumer<T, E extends Throwable> {
    void accept(T t, double value) throws E;
}
