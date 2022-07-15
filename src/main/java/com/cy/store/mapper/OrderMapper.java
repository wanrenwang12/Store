package com.cy.store.mapper;

import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;

import java.util.List;

public interface OrderMapper {

    Integer insertOrder(Order order);

    Integer insertOrderItem(OrderItem orderItem);

    List<Order> selectByUid(Integer uid);

    List<OrderItem> selectItemByOid(Integer oid);
}
