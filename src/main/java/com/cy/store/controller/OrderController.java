package com.cy.store.controller;

import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;
import com.cy.store.service.IOrderService;
import com.cy.store.util.JsonResult;
import com.cy.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/orders")
@RestController
public class OrderController extends BaseController{

    @Autowired
    private IOrderService orderService;

    @RequestMapping("create")
    public JsonResult<Order> create(Integer aid, Integer[] cids, HttpSession session){
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        Order data = orderService.create(aid, uid, username, cids);
        return new JsonResult<>(OK, data);
    }

    @RequestMapping({"", "/"})
    public JsonResult<List<Order>> getOrdersByUid(HttpSession session){
        List<Order> data = orderService.getAllOrders(getuidFromSession(session));
        return new JsonResult<>(OK, data);
    }

    @RequestMapping("{oid}/getAllItem")
    public JsonResult<List<OrderItem>> getOrderItemsByOid(@PathVariable("oid") Integer oid){
        List<OrderItem> data = orderService.getOrderItems(oid);
        return new JsonResult<>(OK, data);
    }
}
