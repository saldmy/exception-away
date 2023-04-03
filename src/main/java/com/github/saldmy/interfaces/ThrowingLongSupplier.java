package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingLongSupplier<E extends Throwable> {
    long getAsLong() throws E;
}
