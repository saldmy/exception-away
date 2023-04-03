package com.github.saldmy;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * This class consists exclusively of a static {@code createFactory} method
 *
 * @author Dmytro Salo
 */
public class MainWrapper {

    private static final MethodHandles.Lookup LOOKUP = MethodHandles.lookup();

    private MainWrapper() {}

    public static MethodHandle createFactory(
            Class<?> targetClass, Class<?> wrapperClass, MethodType methodType, String methodName
    ) {
        try {
            MethodHandle method = LOOKUP.findVirtual(targetClass, methodName, methodType);
            MethodType factoryType = MethodType.methodType(wrapperClass, targetClass);

            CallSite site = LambdaMetafactory.metafactory(
                    LOOKUP, methodName, factoryType, methodType, method, methodType
            );

            return site.getTarget();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

}
