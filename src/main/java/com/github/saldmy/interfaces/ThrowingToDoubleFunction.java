package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingToDoubleFunction<T, E extends Throwable> {
    double applyAsDouble(T value) throws E;
}
