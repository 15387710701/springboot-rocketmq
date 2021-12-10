package com.ms.controller;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 发送延迟消息
 *
 * @author:SmartV
 * @date:2021/9/6 10:51
 */
@RestController
public class Delay {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @RequestMapping("delay")
    public String sendMsg(String message) throws Exception {
        //延迟消息  tag , message , level
        SendResult sendResult = rocketMQTemplate.syncSend("delay", message, 3);
        System.out.println(new Date().toLocaleString());
        System.out.println(sendResult.getMsgId());
        System.out.println(sendResult.getSendStatus());
        return "delay";
    }
}
