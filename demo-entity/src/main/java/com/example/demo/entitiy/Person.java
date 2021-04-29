package com.example.demo.entitiy;

import com.example.demo.entitiy.enumc.Sex;
import com.example.demo.validation.constraints.EnumValid;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@Getter
@Setter
public class Person {

    @EnumValid(target = Sex.class)
    private String sex;

    @Max(100)
    private int age ;

    @Length(min = 12, max = 40)
    private String name;

    @NotNull
    private List<@Email String> emails;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
        log.info("age:{}, name:{}",age,name);
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
