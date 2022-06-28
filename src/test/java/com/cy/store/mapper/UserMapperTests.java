package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTests {
    @Resource
    private UserMapper userMapper;

    /**单元测试条件：可以独立运行， 不需要整个项目启动
     * 必须有@test, 必须void, 必须0参数， 必须public
     */
    @Test
    public void insert(){
        User user = new User();
        user.setUsername("tim");
        user.setPassword("123");
        Integer rows = userMapper.insert(user);
        System.out.println(rows);
    }

    @Test
    public void findByUsername(){
        User user = userMapper.findByUserName("tim");
        System.out.println(user);
    }

    @Test
    public void updatePasswordByUid(){
        userMapper.updatePasswordByUid(6,"321","admin", new Date());
    }

    @Test
    public void findByUid(){
        System.out.println(userMapper.findByUid(6));
    }

    @Test
    public void updateInfoByUid(){
        User user = new User();
        user.setUid(8);
        user.setPhone("19921943475");
        user.setEmail("yang");
        user.setGender(1);
        userMapper.updateInfoByUid(user);
    }


}
