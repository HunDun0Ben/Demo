package com.example.demo.service.util;

public class MockStaticUtil {
    final static String NAME = "MockStaticUtil.java";

    public static String getName(){
        return NAME;
    }

    public static String getChanges(String changes) {
        return changes;
    }

    public static String getStaticMethodName(){
        return "Thread.currentThread().getName()";
    }

    @Override
    public String toString(){
        return "wuhu~";
    }
}
