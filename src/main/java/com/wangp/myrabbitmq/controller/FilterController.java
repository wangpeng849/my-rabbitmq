package com.wangp.myrabbitmq.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filter")
public class FilterController {


    @GetMapping("/test1")
    public String testFilter1(){
        return "test1";
    }

    @GetMapping("/test2")
    public String testFilter2(){
        return "test2";
    }
}
