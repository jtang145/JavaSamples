package cn.naches.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by jtang on 7/3/2017.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ServiceFeignApplication {

    public static void main(String[] args){
        SpringApplication.run(ServiceFeignApplication.class, args);
    }
}
