package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingDoublePredicate<E extends Throwable> {
    boolean test(double value) throws E;
}
