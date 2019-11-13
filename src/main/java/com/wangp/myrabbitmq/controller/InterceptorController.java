package com.wangp.myrabbitmq.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interceptor")
public class InterceptorController {

    @RequestMapping("/unFilter")
    public String unFilterRequest(){
        return "no Filter";
    }
}
