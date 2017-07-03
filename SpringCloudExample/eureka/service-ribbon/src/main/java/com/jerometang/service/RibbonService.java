package com.jerometang.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jtang on 7/3/2017.
 */
@Service
public class RibbonService {
    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "helloError")
    public String sayHelloTo(String name){
        return restTemplate.getForObject("http://SERVICE-EXAMPLE/hi?name=" + name, String.class);
    }


    public String helloError(String name){
        return "Hi " + name + ", You get error for now!";
    }
}
