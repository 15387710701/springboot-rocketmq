package com.ms.controller;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @RequestMapping("demo")
    public String sendMsg(String message, String age) throws Exception {
        SendResult sendResult = rocketMQTemplate.syncSend("tagABCD", message);

        System.out.println(sendResult.getMsgId());
        System.out.println(sendResult.getSendStatus());

        return "success";
    }


}