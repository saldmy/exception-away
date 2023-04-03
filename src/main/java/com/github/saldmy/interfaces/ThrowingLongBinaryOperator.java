package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingLongBinaryOperator<E extends Throwable> {
    long applyAsLong(long left, long right) throws E;
}
