package com.example.rain;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author rain
 * @description:
 * @date 2022/9/6 11:43 上午
 */
public class Test {

    public static void main(String[] args){
        String token = Jwts.builder()
        //主题 放入用户名
                .setSubject("niceyoo")
        //自定义属性 放入用户拥有请求权限
                .claim("authorities","admin")
        //失效时间
            .setExpiration(new Date(System.currentTimeMillis() + 7 * 60 * 1000))
        ///签名算法和密钥
            .signWith(SignatureAlgorithm.HS512, "tmax")
            .compact();
        System.out.println(token);
    }

}
