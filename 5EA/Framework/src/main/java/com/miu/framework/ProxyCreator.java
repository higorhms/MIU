package com.miu.framework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyCreator implements InvocationHandler {
    public static <T> T getInstance(Class<T> unitClass){
        T proxy = (T) Proxy.newProxyInstance(
            unitClass.getClassLoader(),
                new Class[]{unitClass},
                new ProxyCreator()
        );

        return proxy;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Say hello");
        return "Hello";
    }
}
