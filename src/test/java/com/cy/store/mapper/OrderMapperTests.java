package com.cy.store.mapper;


import com.cy.store.entity.Address;
import com.cy.store.entity.District;
import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderMapperTests {

    @Resource
    private OrderMapper orderMapper;


    @Test
    public void insertOrder(){
        Order order = new Order();
        order.setUid(8);
        order.setRecvName("admin");
        order.setRecvPhone("19921943475");
        orderMapper.insertOrder(order);
    }

    @Test
    public void insertOrderItem(){
        OrderItem orderItem = new OrderItem();
        orderItem.setOid(1);
        orderItem.setPid(10000006);
        orderItem.setTitle("三木(SUNWOOD) C4523 票据网格拉链袋/文件袋 12个装 颜色随机");
        orderMapper.insertOrderItem(orderItem);
    }

    @Test
    public void selectAllByUid(){
        List<Order> list = orderMapper.selectByUid(8);
        System.err.println(list.get(1).getOrderTime());
    }

}
