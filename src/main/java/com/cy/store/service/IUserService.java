package com.cy.store.service;

import com.cy.store.entity.User;

public interface IUserService {

    /**
     * register
     * @param user
     */
    void reg(User user);

    /**
     * login module
     * @param username
     * @param password
     * @return user
     */

    User login(String username, String password);
}
