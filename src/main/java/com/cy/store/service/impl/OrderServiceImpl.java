package com.cy.store.service.impl;

import com.cy.store.entity.Address;
import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;
import com.cy.store.mapper.OrderMapper;
import com.cy.store.service.IAddressService;
import com.cy.store.service.ICartService;
import com.cy.store.service.IOrderService;
import com.cy.store.service.ex.InsertException;
import com.cy.store.util.JsonResult;
import com.cy.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Resource
    private OrderMapper orderMapper;

    @Autowired
    private IAddressService addressService;

    @Autowired
    private ICartService cartService;

    @Override
    public Order create(Integer aid, Integer uid, String username, Integer[] cids) {
        List<CartVO> list = cartService.getVOByCid(uid, cids);
        Long totalPrice = 0L;
        for (CartVO c: list){
            totalPrice += c.getRealPrice() * c.getNum();
        }

        Address address = addressService.getByAid(aid, uid);
        Date now = new Date();
        Order order = new Order();
        order.setUid(uid);
        order.setRecvName(address.getName());
        order.setRecvPhone(address.getPhone());
        order.setRecvProvince(address.getProvinceName());
        order.setRecvCity(address.getCityName());
        order.setRecvArea(address.getAreaName());
        order.setRecvAddress(address.getAddress());
        // 补全数据：totalPrice
        order.setTotalPrice(totalPrice);
        // 补全数据：status
        order.setStatus(0);
        // 补全数据：下单时间
        order.setOrderTime(now);
        // 补全数据：日志
        order.setCreatedUser(username);
        order.setCreatedTime(now);
        order.setModifiedUser(username);
        order.setModifiedTime(now);

        Integer rows = orderMapper.insertOrder(order);
        if(rows != 1){
            throw new InsertException("fail to insert");
        }

        for (CartVO cart : list) {
            // 创建订单商品数据
            OrderItem item = new OrderItem();
            // 补全数据：setOid(order.getOid())
            item.setOid(order.getOid());
            // 补全数据：pid, title, image, price, num
            item.setPid(cart.getPid());
            item.setTitle(cart.getTitle());
            item.setImage(cart.getImage());
            item.setPrice(cart.getRealPrice());
            item.setNum(cart.getNum());
            // 补全数据：4项日志
            item.setCreatedUser(username);
            item.setCreatedTime(now);
            item.setModifiedUser(username);
            item.setModifiedTime(now);
            // 插入订单商品数据
            Integer rows2 = orderMapper.insertOrderItem(item);
            if (rows2 != 1) {
                throw new InsertException("插入订单商品数据时出现未知错误，请联系系统管理员");
            }
        }

        //delete from cart
        cartService.deleteFromCart(cids);
        // 返回
        return order;

    }

    @Override
    public List<Order> getAllOrders(Integer uid) {
        return orderMapper.selectByUid(uid);
    }

    @Override
    public List<OrderItem> getOrderItems(Integer oid) {
        return orderMapper.selectItemByOid(oid);
    }
}
