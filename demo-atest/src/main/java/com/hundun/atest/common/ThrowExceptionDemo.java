package com.hundun.atest.common;

public class ThrowExceptionDemo {

    public static void main(String[] args){
        try {
            throwException();
        } catch (Exception e) {
            System.out.println("Function outside.");
        }
    }

    public static void throwException(){
        try {
            throw new Exception("function inside.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
