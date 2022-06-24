package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Mapper;

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
}
