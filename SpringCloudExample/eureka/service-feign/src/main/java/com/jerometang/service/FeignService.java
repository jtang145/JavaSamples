package com.jerometang.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by jtang on 7/3/2017.
 */
@FeignClient(value = "service-example", fallback = FeignServiceFallback.class)
public interface FeignService {
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHelloTo(@RequestParam(value = "name")String name);
}
