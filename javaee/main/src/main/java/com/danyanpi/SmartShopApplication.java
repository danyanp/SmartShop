package com.danyanpi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.danyanpi.dao")
public class SmartShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartShopApplication.class, args);
    }

}
