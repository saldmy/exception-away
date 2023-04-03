package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingDoubleBinaryOperator<E extends Throwable> {
    double applyAsDouble(double left, double right) throws E;
}
