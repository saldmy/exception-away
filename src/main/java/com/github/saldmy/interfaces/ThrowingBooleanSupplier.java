package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingBooleanSupplier<E extends Throwable> {
    boolean getAsBoolean() throws E;
}
