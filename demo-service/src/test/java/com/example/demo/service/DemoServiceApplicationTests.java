package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@PowerMockIgnore({"javax.*.*", "com.sun.*", "org.xml.*", "org.apache.*"})
class DemoServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
