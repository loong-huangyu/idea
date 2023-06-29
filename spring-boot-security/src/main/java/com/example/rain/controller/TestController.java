package com.example.rain.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rain
 * @description:
 * @date 2022/9/5 11:04 下午
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

}
