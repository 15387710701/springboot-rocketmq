package com.ms.consumer.demo;

import com.ms.consumer.demo.mapper.DemoMapper;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author:SmartV
 * @date:2021/9/6 10:58
 */
@Component
@RocketMQMessageListener(
        topic = "order",
        consumerGroup = "my-group", messageModel = MessageModel.BROADCASTING
)
public class CouponConsumer implements RocketMQListener<String> {
    @Autowired
    DemoMapper mapper;

    @Override
    public void onMessage(String s) {
        mapper.updateCoupon1(Long.parseLong(s));
        System.out.println(new Date().toLocaleString());
        System.out.println("更新优惠券-->");
    }
}
