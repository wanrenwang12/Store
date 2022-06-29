package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * User interface 持久层
 */
public interface UserMapper {
    /**
     * insert data
     * @param user
     * @return num of rows influenced
     */
    Integer insert(User user);

    /**
     * check
     * @param username
     * @return user or null
     */
    User findByUserName(String username);

    /**
     * modify password according to Password
     * @param uid
     * @param password
     * @param modifiedUser
     * @param modifiedTime
     * @return the number of rows be influenced
     */
    Integer updatePasswordByUid(Integer uid, String password, String modifiedUser, Date modifiedTime);

    /**
     * return user by uid
     * @param uid
     * @return user or null
     */
    User findByUid(Integer uid);

    /**
     * udpdate user info
     * @param user
     * @return rows be influenced
     */
    Integer updateInfoByUid(User user);

    /**
     * update profile
     * @param uid
     * @param avatar
     * @param modifiedUser
     * @param modifiedTime
     * @return
     */
    Integer updateAvatarByUid(Integer uid,
                              String avatar,
                              String modifiedUser,
                              Date modifiedTime);
}
