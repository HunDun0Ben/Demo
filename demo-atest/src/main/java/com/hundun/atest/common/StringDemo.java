package com.hundun.atest.common;

public class StringDemo {

    public static void main(String[] args){
        // 1) 地址都是常量池中字符串(“”), 故相等 // true
        System.out.println(""=="");
        // 2) 使用 new String() 不会直接使用常量池中的字符串，会重新申请变量 // false
        System.out.println(new String("")=="");
        // 3) 使用 intern 也是获得常量池中的实例 // true
        System.out.println(new String("").intern()=="");
        // 4) 同 2) //false
        System.out.println(new String("")==new String(""));
        // false
        System.out.println(""==null);
        // false
        System.out.println(null=="");

        String c = null;
        StringBuffer s = new StringBuffer();
        // if append is null, StringBuffer can append 'null' , is same to operation '+'
        s.append(",").append(c);
        System.out.println("Operation '+', String = \"," + c + "\"");
        System.out.println("Operation StringBuffer.java, String = \"" + s + "\"");
    }
}
