package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingCallable<V, E extends Throwable> {
    V call() throws E;
}
