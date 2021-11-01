package com.hundun.demo.web.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityTestController {

    @GetMapping("/login")
    public String loginPage() {
        return "true";
    }


    @PostMapping("/login")
    public String doLogin(String name, String passwd) {
        return "true";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/admin/hello")
    public String helloAdmin() {
        return "helloAdmin";
    }

    @GetMapping("/user/hello")
    public String helloUser() {
        return "helloUser";
    }

}
