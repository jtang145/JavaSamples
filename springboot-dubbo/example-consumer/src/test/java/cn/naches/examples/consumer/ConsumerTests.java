package cn.naches.examples.consumer;

import cn.naches.examples.consumer.service.ConsumerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConsumerTests {

    @Autowired
    ConsumerService consumerService;

    @Test
    void testConsumer(){
        String result = consumerService.consume("I'm Jerry!");
        System.out.println(result);
    }
}
