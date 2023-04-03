package com.github.saldmy.wrappers;

import com.github.saldmy.MainWrapper;
import com.github.saldmy.interfaces.ThrowingRunnable;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;


public class RunnableWrapper {
    private static final MethodType RUNNABLE_TYPE = MethodType.methodType(void.class);

    public static Runnable wrap(ThrowingRunnable<? extends Throwable> runnable) {
        try {
            MethodHandle factory = MainWrapper.createFactory(ThrowingRunnable.class, Runnable.class, RUNNABLE_TYPE, "run");
            return (Runnable) factory.invokeExact(runnable);
        } catch (Throwable exc) {
            throw new RuntimeException(exc);
        }
    }
}
