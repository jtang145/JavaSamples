package cn.naches.examples.dubbo.provider.service;

import cn.naches.examples.api.HelloService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class DefaultHelloService implements HelloService {

    public String sayHello(String word) {
        return "Default Service Provider: " + word;
    }
}
