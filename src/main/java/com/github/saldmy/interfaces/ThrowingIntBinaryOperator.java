package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingIntBinaryOperator<E extends Throwable> {
    int applyAsInt(int left, int right) throws E;
}
