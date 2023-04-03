package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingLongToIntFunction<E extends Throwable> {
    int applyAsInt(long value) throws E;
}
