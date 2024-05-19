package com.hjc.boot.task.controller;


import com.hjc.boot.task.utils.CreateUtils;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/get")
public class TablesController {

    @Resource
    private CreateUtils createUtils;

    @GetMapping("/g")
    public void get() {

        createUtils.get();


    }
}
