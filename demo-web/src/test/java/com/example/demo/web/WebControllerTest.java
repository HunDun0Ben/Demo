package com.example.demo.web;


import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest()

@PowerMockRunnerDelegate(SpringRunner.class)

@WebMvcTest(WebControllerTest.class)
@ContextConfiguration(classes = { DemoWebApplication.class })

@Rollback
public class WebControllerTest {

}
