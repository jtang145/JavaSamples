package com.jerometang.web;

import com.jerometang.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jtang on 7/3/2017.
 */
@RestController
public class RibbonControler {

    @Autowired
    RibbonService ribbonService;

    @RequestMapping("/ribbon-hi")
    public String sayHello(@RequestParam String name){
        return ribbonService.sayHelloTo(name);
    }
}
