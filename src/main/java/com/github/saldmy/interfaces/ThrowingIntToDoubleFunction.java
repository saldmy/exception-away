package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingIntToDoubleFunction<E extends Throwable> {
    double applyAsDouble(int value) throws E;
}
