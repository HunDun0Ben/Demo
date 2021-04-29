package com.example.demo.entitiy.enumc;

import com.example.demo.validation.EnumEqual;

public enum Sex implements EnumEqual {
    // 男性
    MAN("男", 1),
    // 女性
    WOMAN("女", 0),
    // 未知性别
    UNKNOWN("未知", -1);

    Sex(String name, int type) {
        this.name = name;
        this.type = type;
    }

    String name;
    int type;

    @Override
    public Object getEqualObject() {
        return name().toLowerCase();
    }
}
