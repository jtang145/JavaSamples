package cn.naches.examples.springboot.redis.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * Created by jtang on 7/14/2017.
 */
public class SampleReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(SampleReceiver.class);

    private CountDownLatch latch;

    @Autowired
    public SampleReceiver(CountDownLatch latch){
        this.latch = latch;
    }

    //Receive and handle message
    public void receiveMessage(String incomingMessage){
        LOGGER.info("Receiving message: " + incomingMessage);
        //Do something as you like
        latch.countDown();
    }
}
