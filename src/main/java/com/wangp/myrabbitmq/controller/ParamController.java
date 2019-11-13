package com.wangp.myrabbitmq.controller;

import com.wangp.myrabbitmq.enums.CloudEnum;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class ParamController {

    @RequestMapping("/test/{appid}")
    public String getParam(@PathVariable("appid") String appid){
        return CloudEnum.getUrlById(appid);
    }
}
