package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingBiPredicate<T, U, E extends Throwable> {
    boolean test(T t, U u) throws E;
}
