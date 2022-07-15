package com.cy.store.service;

import com.cy.store.entity.Address;
import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;

import java.util.List;

public interface IOrderService {

    Order create(Integer aid, Integer uid, String username, Integer[] cids);

    List<Order> getAllOrders(Integer uid);

    List<OrderItem> getOrderItems(Integer oid);
}
