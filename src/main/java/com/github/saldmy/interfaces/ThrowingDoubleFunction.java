package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingDoubleFunction<R, E extends Throwable> {
    R apply(double value) throws E;
}
