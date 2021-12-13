package com.hundun.demo.web.controller;

import com.hundun.demo.entity.Lottery;
import com.hundun.demo.facade.LotteryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lottery")
@Slf4j
public class LotteryController {

    @DubboReference(version = "1.0.0", group = "test", interfaceClass = LotteryService.class )
    LotteryService lotteryService;

    @RequestMapping("/bigLottery/random")
    public String randomBigLottery() {
        Lottery lottery = lotteryService.getRandLottery();
        return lottery.getPrintNumber();
    }
}
