package com.cy.store.service;

import com.cy.store.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findHotList();

    Product findById(Integer id);

    List<Product> findRecentList();

    List<Product> findByCategoryId(Integer categoryId, Integer pageNum, Integer pageSize);

    Integer countByCategoryId(Integer categoryId);
}
