package com.hundun.demo.entity.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.hundun.demo.**.mapper")
public class MybatisConfiguration {

}
