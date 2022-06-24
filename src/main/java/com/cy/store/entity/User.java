package com.cy.store.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 *Entity for users in store
 */
@Data
public class User extends BaseEntity implements Serializable {
    private Integer uid;
    private String username;
    private String password;
    private String salt;
    private String phone;
    private String email;
    private Integer gender;
    private String avatar;
    private Integer isDelete;
}
