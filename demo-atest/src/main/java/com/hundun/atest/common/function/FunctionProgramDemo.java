package com.hundun.atest.common.function;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FunctionProgramDemo {
    public static void main(String[] args) {
        Student student = supplierExample();
        consumerExample(student);
    }

    public static Student supplierExample(){
        Supplier<Student> supplier = new Supplier<Student>() {
            @Override
            public Student get() {
                Student stu = Student.builder().name("aaa").build();
                System.out.println("[Supplier Example] : Student Address " + stu);
                return stu;
            }
        };
        // 有点类似 Factory 的方法。
        Supplier<Student> singletonSupplier = new Supplier<Student>() {
            private Student instance = null;
            @Override
            public synchronized Student get() {
                if(instance == null) {
                    synchronized (this) {
                       instance = instance == null
                               ? instance = Student.builder().name("aaa").build()
                               : instance;
                    }
                }
                System.out.println("[Supplier Example] : Singleton Student Address " + instance);
                return instance;
            }
        };
        Student singleton1 = singletonSupplier.get();
        Student singleton2 = singletonSupplier.get();
        System.out.println("Singleton model : " + singleton1.equals(singleton2));
        Student stu1 = supplier.get();
        Student stu2 = supplier.get();
        System.out.println("Common model : " + stu1.equals(stu2));
        return singleton1;
    }

    public static void consumerExample(Student student){
        Consumer<Student> addOneName = new Consumer<Student>() {
            @Override
            public void accept(Student stu) {
                stu.name = stu.name + "1";
            }
        };
        // 下方的这个形式是上方的简写方式. 单个语句可以不适用花括号. 
        Consumer<Student> addThreeName = stu -> stu.name = stu.name + "2";
        // accept 方法 return void; 自身习惯并且比较完整的写法。
        Consumer<Student> lamdaExample = (stu) -> { stu.name = stu.name + "3"; return; };

        List<Student> list = new ArrayList<>();
        list.add(student);
        // 多个 consumer 串联执行返回。
        // andThen = ConsumerA.accept() -> consumerB.accept()
        list.forEach(addOneName.andThen(addThreeName));
        System.out.println(student.name);
    }

    @Builder
    static class Student{
        public String name;
    }
}
