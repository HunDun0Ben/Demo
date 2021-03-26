package com.example.demo.web.controller;

import com.example.demo.entitiy.BigLottery;
import com.example.demo.entitiy.Lottery;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lottery")
public class LotteryController {

    @RequestMapping("/bigLottery/random")
    public String randomBigLottery(){
        Lottery lottery = new BigLottery();
        lottery.generateNumber();
        return lottery.getPrintNumber();
    }

}
