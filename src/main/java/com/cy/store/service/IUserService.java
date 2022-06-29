package com.cy.store.service;

import com.cy.store.entity.User;

import java.util.Date;

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

    /**
     *
     * @param uid
     * @param username
     * @param oldPassword
     * @param newPassword
     */
    void changePassword(Integer uid,
                        String username,
                        String oldPassword,
                        String newPassword);

    /**
     * find by uid
     * @param uid
     * @return user
     */
    User getByUid(Integer uid);

    /**
     * update info
     * @param uid
     * @param username
     * @param user
     */
    void changeInfo(Integer uid, String username, User user);

    /**
     * change profile
     * @param uid
     * @param avatar
     * @param username
     */
    void changeAvatar(Integer uid,
                      String avatar,
                      String username);
}
