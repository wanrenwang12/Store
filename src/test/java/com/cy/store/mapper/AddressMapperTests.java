package com.cy.store.mapper;


import com.cy.store.entity.Address;
import com.cy.store.entity.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressMapperTests {

    @Resource
    private AddressMapper addressMapper;

    @Resource
    private DistrictMapper districtMapper;

    @Test
    public void insert(){
        Address address = new Address();
        address.setUid(8);
        address.setPhone("19999999");
        address.setName("Tom");
        addressMapper.insert(address);
    }

    @Test
    public void countByUid(){
        Integer count = addressMapper.countByUid(8);
        System.out.println(count);
    }

    @Test
    public void getByParent(){
        List<District> list = districtMapper.findByParent("86");
        for (District d:list){
            System.out.println(d);
        }
    }


}
