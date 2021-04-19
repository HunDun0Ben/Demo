package com.example.demo.entitiy;

import java.io.Serializable;

public interface Lottery extends Serializable {
    /**
     * 生成号码
     */
    void generateNumber();

    /**
     * 打印出号码
     * @return 可视化 String
     */
    String getPrintNumber();
}
