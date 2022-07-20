package com.cy.store.service;

import com.cy.store.entity.Product;
import com.cy.store.service.IProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceTests {

    @Autowired
    private IProductService productService;

    @Test
    public void findHot(){
        List<Product> list = productService.findHotList();
        System.err.println(list);
    }

    @Test
    public void findRecent(){
        List<Product> list = productService.findRecentList();
        System.err.println(list);
    }

    @Test
    public void findByCategoryID(){
        List<Product> list = productService.findByCategoryId(238, 2, 2);
        System.err.println(list);
    }

    @Test
    public void count(){
        Integer res = productService.countByCategoryId(241);
        System.err.println(res);
    }
}
