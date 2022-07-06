package com.cy.store.mapper;

import com.cy.store.entity.Cart;
import com.cy.store.vo.CartVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CartMapperTests {

    @Resource
    private CartMapper cartMapper;

    @Test
    public void insert(){
        Cart cart = new Cart();
        cart.setUid(8);
        cart.setPid(10000011);
        cart.setNum(2);
        cart.setPrice(1000L);
        cartMapper.insert(cart);
    }

    @Test
    public void updateNum(){
        cartMapper.updateNumByCid(1, 4, "admin", new Date());

    }

    @Test
    public void findByUidAndPid(){
        System.err.println(cartMapper.findByUidAndPid(8, 10000011));
    }

    @Test
    public void findVOByUid(){
        System.err.println(cartMapper.findVOByUid(8));
    }

}
