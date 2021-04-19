package com.example.demo.service.facade.impl;

import com.example.demo.entitiy.BigLottery;
import com.example.demo.entitiy.Lottery;
import com.example.demo.service.facade.LotteryService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = "1.0.0", group = "test", interfaceClass = LotteryService.class )
public class LotteryServiceImpl implements LotteryService {

    @Override
    public Lottery getNewLottery() {
        Lottery lottery = new BigLottery();

        lottery.generateNumber();
        return lottery;
    }
}
