package com.example.beaninit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.beaninit.bean.MaxBean;
import com.example.beaninit.bean.WhyBean;
import com.example.beaninit.spring.SofaAsyncInit;

@SpringBootApplication
public class BeanInitApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeanInitApplication.class, args);
    }

    @Bean(value = "why", initMethod = "init")
    @SofaAsyncInit
    public WhyBean whyBean() {
        return new WhyBean();
    }

    @Bean(value = "max", initMethod = "init")
    @SofaAsyncInit
    public MaxBean maxBean() {
        return new MaxBean();
    }

}
