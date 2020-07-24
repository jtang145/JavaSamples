package cn.naches.examples.consumer.controller;

import cn.naches.examples.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Index {

    @Autowired
    ConsumerService consumerService;

    @GetMapping(produces = "application/json")
    public String sayHello(@RequestParam(required = false) String greeting){
        String realWord = greeting;
        if(realWord == null){
            realWord = "Dummy";
        }
        return consumerService.consume(realWord);
    }
}
