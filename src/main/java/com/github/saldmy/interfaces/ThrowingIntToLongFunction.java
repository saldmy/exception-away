package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingIntToLongFunction<E extends Throwable> {
    long applyAsLong(int value) throws E;
}
