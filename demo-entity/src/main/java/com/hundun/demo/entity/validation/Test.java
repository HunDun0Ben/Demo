package com.hundun.demo.entity.validation;

import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {
        Class<EnumTest> cls = EnumTest.class;
        Object[] objs = cls.getEnumConstants();
        Method method = cls.getMethod("name");
        Method getMethod = cls.getMethod("getName");

        for (Object obj : objs) {
            Object name = getMethod.invoke(obj);
            System.out.println(name);
        }

        for (EnumTest value : EnumTest.values()) {
                System.out.println(value.name());
                EnumTest t = EnumTest.valueOf(value.name());
                System.out.println(t);
        }
        
        
    }
}
