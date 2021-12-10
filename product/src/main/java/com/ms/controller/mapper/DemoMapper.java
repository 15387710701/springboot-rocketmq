package com.ms.controller.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ms.controller.entity.Demo;
import org.apache.ibatis.annotations.Update;

/**
 * @author:SmartV
 * @date:2021/9/6 11:38
 */
public interface DemoMapper extends BaseMapper<Demo> {
    @Update("update demo set coupon_status=1")
    void updateCoupon(Long id);

    @Update("update demo set balance=balance-1")
    void updateBalance(Long id);

    @Update("update demo set order_status=1")
    void updateOrder(Long id);
}
