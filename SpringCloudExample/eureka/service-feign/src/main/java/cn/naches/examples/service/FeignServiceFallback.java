package cn.naches.examples.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by jtang on 7/3/2017.
 */
@Component
public class FeignServiceFallback implements FeignService {
    @Override
    public String sayHelloTo(@RequestParam(value = "name") String name) {
        return "Sorry, request failed for " + name;
    }
}
