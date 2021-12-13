package com.hundun.demo.service;

import com.hundun.demo.facade.DemoServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@SpringBootTest
//@PowerMockIgnore({"javax.*.*", "com.sun.*", "org.xml.*", "org.apache.*"})
//@PowerMockRunnerDelegate(SpringRunner.class)
//@RunWith(PowerMockRunner.class)
//@PrepareForTest()
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoServiceApplication.class)
public class DemoServiceApplicationTest {

    @Test
    public void contextLoads() {
        System.out.println(DemoServiceApplication.class.getName());
    }

}
