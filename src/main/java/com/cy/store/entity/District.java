package com.cy.store.entity;

import lombok.Data;

@Data
public class District extends BaseEntity{
    private Integer id;
    private String parent; // 父亲代号
    private String code; //本身代号
    private String name;
}
