package com.example.beaninit.bean;

import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

/**
 * @author rain
 * @description:
 * @date 2023/6/20 2:14 下午
 */
@Slf4j
public class WhyBean {

    public void init() throws InterruptedException {
        log.info("WhyBean start thread name '{}' ", Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(5);
        log.info("WhyBean end thread name '{}' ", Thread.currentThread().getName());
    }

}
