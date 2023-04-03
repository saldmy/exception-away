package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingIntFunction<R, E extends Throwable> {
    R apply(int value) throws E;
}
