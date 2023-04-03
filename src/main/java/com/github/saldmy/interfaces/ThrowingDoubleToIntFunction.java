package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingDoubleToIntFunction<E extends Throwable> {
    int applyAsInt(double value) throws E;
}
