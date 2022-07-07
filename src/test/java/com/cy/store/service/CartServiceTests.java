package com.cy.store.service;

import com.cy.store.service.ICartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CartServiceTests {
    @Autowired
    private ICartService cartService;

    @Test
    public void addToCart(){
        cartService.addToCart(8, 10000008, 8, "zhangsan");
    }

    @Test
    public void addNum(){
        cartService.addNum(1, 8, "zhangsan");
    }
}
