package com.example.demo.service.demo;

import com.example.demo.entitiy.Lottery;
import com.example.demo.service.facade.LotteryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@PowerMockIgnore({"javax.*.*", "com.sun.*", "org.xml.*", "org.apache.*"})
@PowerMockRunnerDelegate(SpringRunner.class)
@RunWith(PowerMockRunner.class)
@PrepareForTest()
class DemoServiceApplicationTests {

    @Autowired
    private LotteryService lotteryService;

	@Test
	void Test_LotteryBigNum() {
        Lottery lottery = lotteryService.getNewLottery();
        lottery = null;
        Assert.assertNotNull("error", lottery);
        System.out.println(lottery.getPrintNumber());
    }

}
