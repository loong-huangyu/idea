package com.example.rain.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author rain
 * @description:
 * @date 2022/9/5 11:18 下午
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    //基于内存的用户存储
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("itguang").password("123456").roles("USER").and()
            .withUser("admin").password("{noop}" + "123456").roles("ADMIN");
    }

    //请求拦截
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .anyRequest().permitAll()
            .and()
            .formLogin()
            .permitAll()
            .and()
            .logout()
            .permitAll();
    }

}
