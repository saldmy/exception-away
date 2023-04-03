package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingDoubleUnaryOperator<E extends Throwable> {
    double applyAsDouble(double operand) throws E;
}
