package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingIntPredicate<E extends Throwable> {
    boolean test(int value) throws E;
}
