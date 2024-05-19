package com.hjc.boot.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
//@EnableScheduling
@SpringBootApplication
public class TaskApplication {

    public static void main(String[] args) {
        // 启动Spring Boot应用
        SpringApplication.run(TaskApplication.class, args);
    }
}
