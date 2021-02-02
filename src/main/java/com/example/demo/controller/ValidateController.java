package com.example.demo.controller;

import com.example.demo.entitiy.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/validate")
@Slf4j
public class ValidateController {

    @PostMapping("/demo")
    public Person requestDemo(@Valid @RequestBody Person person /*, Errors errors*/) {
        System.out.println("This is Validate Demo.");
        String sql = "";
        String corpId = "";

        return person;
    }
}
