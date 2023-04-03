package com.github.saldmy.interfaces;

@FunctionalInterface
public interface ThrowingLongPredicate<E extends Throwable> {
    boolean test(long value) throws E;
}
