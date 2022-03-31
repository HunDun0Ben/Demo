package com.hundun.demo.service.service;

import org.junit.Test;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

public class SpringUnitTest extends AbstractJUnit4SpringContextTests {

    @Test
    public void test() {
        String name = applicationContext.getApplicationName();
        System.err.println(name);
    }
}
