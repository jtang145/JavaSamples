package com.jerometang.springboot.redis;

import com.jerometang.springboot.redis.message.SampleReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.CountDownLatch;

/**
 * Created by jtang on 7/14/2017.
 */
@SpringBootApplication
public class SpringBootRedisApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootRedisApplication.class);

    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory){
        return new StringRedisTemplate(connectionFactory);
    }

    @Bean
    CountDownLatch latch(){
        return new CountDownLatch(1);
    }

    @Bean
    SampleReceiver receiver(CountDownLatch latch){
        return new SampleReceiver(latch);
    }

    @Bean
    MessageListenerAdapter listenerAdapter(SampleReceiver sampleReceiver){
        return new MessageListenerAdapter(sampleReceiver, "receiveMessage");
    }

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic("topic"));
        return container;
    }


    public static void main(String []args) throws InterruptedException {
        ApplicationContext ctx = SpringApplication.run(SpringBootRedisApplication.class, args);

        StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
        CountDownLatch latch = ctx.getBean(CountDownLatch.class);

        LOGGER.info("Preparing to send message");
        template.convertAndSend("topic", "Hello redis template message");

        latch.await();

        System.exit(0);
    }
}