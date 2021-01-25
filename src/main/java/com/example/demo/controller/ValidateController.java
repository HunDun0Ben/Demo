package com.example.demo.controller;

import com.example.demo.entitiy.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
@RequestMapping("/validate")
@Slf4j
public class ValidateController {

    JdbcTemplate jdbcTemplate;

    @PostMapping("/demo")
    public Person requestDemo(@Valid @RequestBody Person person /*, Errors errors*/) {
        System.out.println("This is Validate Demo.");
//        if(errors.hasErrors()) {
//            log.error(errors.toString());
//        }
        String sql = "";
        String corpId = "";
        this.jdbcTemplate.query(sql, new Object[]{corpId}, new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Person();
            }
        });

        return person;
    }
}
