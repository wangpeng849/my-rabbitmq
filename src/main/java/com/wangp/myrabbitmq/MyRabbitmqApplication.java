package com.wangp.myrabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.wangp.myrabbitmq.filer")
public class MyRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyRabbitmqApplication.class, args);
    }

}
