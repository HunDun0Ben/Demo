package com.example.demo.service.demo;

import org.junit.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
public class UnitTest {

    public UnitTest() {
        System.out.println("===== Construct!!!!");
    }

    @BeforeClass
    public static void beforeClass() throws Exception {

    }

    @BeforeClass
    public static void beforeClassInit() {
        System.out.println("[@BeforeClass] beforeClassInit");
    }

    @AfterClass
    public static void afterClassInit() {
        System.out.println("[@AfterClass] afterClassInit");
    }

    @Before
    public void beforeEveryMethod() {
        System.out.println("[@Before] beforeEveryMethod");
    }

    @After
    public void afterEveryMethod() {
        System.out.println("[@After] afterEveryMethod");
    }

    @Test
    public void test1(){
        System.out.println("test1");
        Assert.assertSame("123","123");
    }

    @Test
    public void test2(){
        System.out.println("test2");
        Assert.assertSame("123",new String("123"));
    }
}
