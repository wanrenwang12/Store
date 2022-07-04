package com.cy.store.mapper;

import com.cy.store.entity.Product;

import java.util.List;

public interface ProductMapper {

    /**
     * hot hit
     * @return
     */
    List<Product> findHotList();

    Product findById (Integer id);

}
