package com.example.demo.validation;

public enum EnumTest implements EnumEqual {
    ONE("_ONE",1),
    TWO("_TWO",2),
    THREE("_THREE",3);
    private String name;
    private Integer code;

    EnumTest() {
    }

    EnumTest(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public Object getEqualObject() {
        return this.getName();
    }
}
