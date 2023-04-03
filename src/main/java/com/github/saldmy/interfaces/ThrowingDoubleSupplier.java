package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingDoubleSupplier<E extends Throwable> {
    double getAsDouble() throws E;
}
