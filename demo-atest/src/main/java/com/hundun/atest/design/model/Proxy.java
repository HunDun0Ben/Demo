package com.hundun.atest.design.model;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

interface IHelloWorld {
    void hello();
}

class HelloWorld implements IHelloWorld {
    @Override
    public void hello() {
        System.out.println("hello world！");
    }
}

public class Proxy {
    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        Class[] interfaces = helloWorld.getClass().getInterfaces();
        Object res = java.lang.reflect.Proxy.newProxyInstance(helloWorld.getClass().getClassLoader(), interfaces, new helloProxyHandler(helloWorld));
        IHelloWorld i = (IHelloWorld) res;
        i.hello();
    }
}

class helloProxyHandler implements InvocationHandler {

    private final Object xproxy;

    public helloProxyHandler(Object xproxy) {
        this.xproxy = xproxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = method.invoke(xproxy, args);
        long responseTime = System.currentTimeMillis() - startTime;
        String apiName = xproxy.getClass().getName() + ":" + method.getName() + ": args, " + (args != null ? Arrays.toString(args) : null);
        System.out.println(apiName);
        System.out.println(responseTime);
        return result;
    }
}

