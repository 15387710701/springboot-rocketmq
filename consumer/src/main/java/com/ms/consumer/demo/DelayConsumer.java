package com.ms.consumer.demo;

import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author:SmartV
 * @date:2021/9/6 10:58
 */
@Component
@RocketMQMessageListener(
        topic = "delay",
        consumerGroup = "my-group", messageModel = MessageModel.BROADCASTING
)
public class DelayConsumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        System.out.println(new Date().toLocaleString());
        System.out.println("延迟消息1-->" + s);
    }
}
