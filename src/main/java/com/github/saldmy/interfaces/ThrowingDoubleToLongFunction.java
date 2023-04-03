package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingDoubleToLongFunction<E extends Throwable> {
    long applyAsLong(double value) throws E;
}
