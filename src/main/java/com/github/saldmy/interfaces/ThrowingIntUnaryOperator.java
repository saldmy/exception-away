package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingIntUnaryOperator<E extends Throwable> {
    int applyAsInt(int operand) throws E;
}
