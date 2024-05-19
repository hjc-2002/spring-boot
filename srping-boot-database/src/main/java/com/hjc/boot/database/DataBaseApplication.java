package com.hjc.boot.database;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.hjc.boot.database.mapper"})
public class DataBaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataBaseApplication.class,args);
    }
}
