package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingToLongFunction<T, E extends Throwable> {
    long applyAsLong(T value) throws E;
}
