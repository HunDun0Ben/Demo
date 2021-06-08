package com.hundun.demo.service.facade.impl;

import com.hundun.demo.entity.BigLottery;
import com.hundun.demo.entity.Lottery;
import com.hundun.demo.service.facade.LotteryService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = "1.0.0", group = "test", interfaceClass = LotteryService.class )
public class LotteryServiceImpl implements LotteryService {

    public LotteryServiceImpl() {
        System.out.println("【LotteryService】Init class is directory java file.");
    }

    @Override
    public Lottery getNewLottery() {
        Lottery lottery = new BigLottery();
        lottery.generateNumber();
        return lottery;
    }
}
