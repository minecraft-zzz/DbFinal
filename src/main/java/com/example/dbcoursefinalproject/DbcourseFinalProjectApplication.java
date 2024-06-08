package com.example.dbcoursefinalproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.dbcoursefinalproject.mapper")
@SpringBootApplication
public class DbcourseFinalProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbcourseFinalProjectApplication.class, args);
    }

}
