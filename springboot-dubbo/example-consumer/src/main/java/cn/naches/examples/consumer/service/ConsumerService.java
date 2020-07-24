package cn.naches.examples.consumer.service;

import cn.naches.examples.api.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Reference(version = "1.0.0")
    HelloService helloService;

    public String consume(String greeting){
        String echo = helloService.sayHello(greeting);
        return echo;
    }
}
