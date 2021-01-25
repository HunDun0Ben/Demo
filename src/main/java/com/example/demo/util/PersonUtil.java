package com.example.demo.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Getter
@Setter
public class PersonUtil {

    private int age ;
    private String name;

    public PersonUtil(@Value("${person.age}") int age, @Value("${person.name}")String name) {
        this.age = age;
        this.name = name;
        log.info("age:{}, name:{}",age,name);
    }
}
