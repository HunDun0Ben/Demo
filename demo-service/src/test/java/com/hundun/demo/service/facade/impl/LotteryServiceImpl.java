package com.hundun.demo.service.facade.impl;

import com.hundun.demo.entity.Lottery;
import com.hundun.demo.service.facade.LotteryService;

public class LotteryServiceImpl implements LotteryService {

    public LotteryServiceImpl() {
        System.out.println("【LotteryService】Init class is directory test file.");
    }

    @Override
    public Lottery getNewLottery() {
        return null;
    }
}
