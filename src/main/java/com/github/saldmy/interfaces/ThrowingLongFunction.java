package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingLongFunction<R, E extends Throwable> {
    R apply(long value) throws E;
}
