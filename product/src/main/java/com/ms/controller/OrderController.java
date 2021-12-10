package com.ms.controller;

import com.ms.controller.mapper.DemoMapper;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class OrderController {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    @Autowired
    DemoMapper mapper;

    @RequestMapping("order")
    public String sendMsg(Long id) throws Exception {

        try {
            //扣减优惠券

            mapper.updateCoupon(id);
            //扣减余额
            mapper.updateBalance(id);
            int i = 1 / 0;
            //确认订单
            mapper.updateOrder(id);
        } catch (Exception e) {
            e.printStackTrace();
            //手动回滚
            rocketMQTemplate.syncSend("order", String.valueOf(id));
            System.out.println(new Date().toLocaleString());
            return e.getMessage();
        }
        return "ok";

    }


    @RequestMapping("order1")
    public String sendTransactionMsg(Long id) throws Exception {

        try {

        } catch (Exception e) {
            e.printStackTrace();
            //手动回滚
            rocketMQTemplate.syncSend("order", String.valueOf(id));
            System.out.println(new Date().toLocaleString());
            return e.getMessage();
        }
        return "ok";

    }
}