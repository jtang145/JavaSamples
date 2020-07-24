package cn.naches.examples;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jtang on 7/3/2017.
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableConfigServer
public class ServiceExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceExampleApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam String name){
        return new StringBuilder("Hellow world to ").append(name).append(" from port ").append(port).toString();
    }
}
