package com.ms.controller.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author:SmartV
 * @date:2021/9/6 11:37
 */
@TableName("demo")
public class Demo {
    private int id;
    private int coupon_status;
    private int balance;
    private int order_status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCoupon_status() {
        return coupon_status;
    }

    public void setCoupon_status(int coupon_status) {
        this.coupon_status = coupon_status;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }
}
