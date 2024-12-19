package com.example.onlineeducationplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.onlineeducationplatform.mapper")
public class OnlineEducationPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineEducationPlatformApplication.class, args);
    }

}
