package com.example.liuos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.redis.core.RedisTemplate;

@ServletComponentScan
@SpringBootApplication
@Slf4j
public class LiuOsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiuOsApplication.class, args);
    }

}
