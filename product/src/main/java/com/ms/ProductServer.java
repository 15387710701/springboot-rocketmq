package com.ms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author:SmartV
 * @date:2021/9/2 12:43
 */
@MapperScan("com.ms.controller.mapper")
@SpringBootApplication
public class ProductServer {
    public static void main(String[] args) {
        SpringApplication.run(ProductServer.class);
    }
}
