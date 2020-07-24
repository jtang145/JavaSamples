package cn.naches.examples.springboot.basic;

import cn.naches.examples.springboot.basic.bean.User;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
import io.prometheus.client.exporter.PushGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@EnableAutoConfiguration
@EnableConfigurationProperties({User.class})
public class Example {
    static final CollectorRegistry registry = new CollectorRegistry();
    static final Counter default_requests = Counter.build().name("sayHello_requests_total").help("SayHello Total requests").register(registry);
    static PushGateway gateway;

    @RequestMapping("/")
    String home() {
        default_requests.inc();
        pushMetrics("sayHello_requests_total");
        return "Hello World!";
    }

    private void pushMetrics(String job) {
        try {
            gateway.pushAdd(registry, job);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    User user;

    @RequestMapping("/admin")
    String admin() {
        return user.getName() + ", is " + user.getSex();
    }

    // Set up multipile applications
    public static void main(String[] args) throws Exception {
        startMonitor();
//        SpringApplication.run("com.itang.basic_sample.basic", args);

        SpringApplication.run(Example.class, args);
//        Thread anotherApplication = new Thread() {
//            @Override
//            public void run() {
//                ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//            }
//        };
//        anotherApplication.start();
    }

    private static void startMonitor() {

        gateway = new PushGateway("127.0.0.1:9091");
    }

}