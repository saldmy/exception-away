package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingBinaryOperator<T, E extends Throwable> {
    T apply(T left, T right) throws E;
}
