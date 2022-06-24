package com.cy.store.service.impl;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.UsernameDuplicatedException;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void reg(User user){
        //check duplicate
        String username = user.getUsername();
        User result = userMapper.findByUserName(username);
        if(result != null){
            throw new UsernameDuplicatedException("The name has been registered");
        }

        //encryption:MD5
        // MD5(salt + pwd + salt) for 3 times
        String originalPassword = user.getPassword();
        //get salt randomly
        String salt = UUID.randomUUID().toString().toUpperCase();
        String md5Password = getMD5Password(originalPassword, salt);


        // fill in data
        user.setPassword(md5Password);
        user.setSalt(salt);

        user.setIsDelete(0);
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        Integer rows = userMapper.insert(user);
        if (rows != 1){
            throw new InsertException("Unknown error when we are registering");
        }
    }

    /**
     * Util for get encryption password
     * @param password
     * @param salt
     * @return
     */
    private String getMD5Password(String password, String salt){
        for (int i = 0; i < 3; i++){
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }


}
