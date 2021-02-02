package com.example.demo.entitiy;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BigLottery implements Lottery {

    private List<@Max(35) @Min(1) Integer> upperHalf;

    private List<@Max(12) @Min(1) Integer> lowerHalf;

    public BigLottery() {
    }

    @Override
    public void generateNumber() {
        this.upperHalf = this.generalNumber(35,1, 5);
        this.lowerHalf = this.generalNumber(12,1, 2);
    }

    @Override
    public String getPrintNumber() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Upper Half :");
        upperHalf.forEach(v->{
            buffer.append(String.format("%2d", v)).append(", ");
        });
        buffer.append("\nLower Half :");
        lowerHalf.forEach(v->{
            buffer.append(String.format("%2d", v)).append(", ");
        });
        return buffer.toString();
    }

    Random random = new Random();
    private List<Integer> generalNumber(int max, int min, int size){
        List<Integer> list = new ArrayList();
        for (int i = 0; i < size; ) {
            random.setSeed(System.currentTimeMillis());
            int num = random.nextInt() % max + min;
            num = num < 0 ? -num : num;
            if (!list.contains(num)) {
                list.add(num);
                i++;
            }
        }
        list.sort(Integer::compareTo);
        return list;
    }
}
