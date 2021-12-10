package com.ms.consumer.demo;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(
        topic = "tagA",
        consumerGroup = "my-group"
)
public class HelloConsumer1 implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        System.out.println("HelloConsumer消费消息" + message);
    }
}