package com.hundun.demo.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("user").roles("user")
                .and().withUser("admin").password("admin").roles("admin");
    }

    // 配置 Spring Security 的 Filter 链
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.debug(true);
    }

    // 配置如何通过拦截器保护请求
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 权限请求设置
        http.authorizeRequests()
                .antMatchers("/user/**").hasRole("user")
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated();
        // 登录页面相关设置
        http.formLogin().loginPage("/login").loginProcessingUrl("/login")
                .passwordParameter("passwd")
                .usernameParameter("name")
                .permitAll();
        // 其他设置
        http.httpBasic()
            .and().csrf().disable();
    }
}
