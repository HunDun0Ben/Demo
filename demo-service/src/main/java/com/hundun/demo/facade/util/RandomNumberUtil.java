package com.hundun.demo.facade.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberUtil {

    private static Random random = new Random();

    public static Integer getRandomNum(int max, int min){
        random.setSeed(System.currentTimeMillis());
        int num = random.nextInt() % max + min;
        num = num < 0 ? -num : num;
        return num;
    }

    public static List<Integer> getRandomList(int max, int min, int size){
        return getRandomList(max, min, size, false);
    }

    public static List<Integer> getRandomList(int max, int min, int size, boolean sort){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; ) {
            int num = getRandomNum(max,min);
            if (!list.contains(num)) {
                list.add(num);
                i++;
            }
        }
        if(sort) {
            list.sort(Integer::compareTo);
        }
        return list;
    }
}
