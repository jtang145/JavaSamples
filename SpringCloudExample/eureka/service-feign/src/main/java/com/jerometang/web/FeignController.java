package cn.naches.examples.web;

import cn.naches.examples.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jtang on 7/3/2017.
 */
@RestController
public class FeignController {
    @Autowired
    FeignService feignService;

    @RequestMapping(value = "/feign-hi", method = RequestMethod.GET)
    public String sayHelloTo(@RequestParam String name){
        return feignService.sayHelloTo(name);
    }
}
