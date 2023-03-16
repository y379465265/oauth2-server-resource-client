package com.izejin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.izejin.dao")
public class Server_9000 {
    public static void main(String[] args) {
        SpringApplication.run(Server_9000.class, args);
    }
}

