package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingToIntFunction<T, E extends Throwable> {
    int applyAsInt(T value) throws E;
}
