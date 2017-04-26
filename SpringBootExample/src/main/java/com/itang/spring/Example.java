package com.itang.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Example {

    @RequestMapping("/main/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/app2/")
    String app2() {
        return "com.itang.spring.Example application is serving you!";
    }

    public static void main(String[] args) throws Exception {
//        SpringApplication.run("com.itang.spring", args);

        SpringApplication.run(Example.class, args);
//        Thread anotherApplication = new Thread() {
//            @Override
//            public void run() {
//                ConfigurableApplicationContext context = SpringApplication.run(com.itang.spring.Application.class, args);
//            }
//        };
//        anotherApplication.start();
    }

}