package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingIntSupplier<E extends Throwable> {
    int getAsInt() throws E;
}
