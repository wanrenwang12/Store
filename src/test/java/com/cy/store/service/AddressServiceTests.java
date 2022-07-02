package com.cy.store.service;

import com.cy.store.entity.Address;
import com.cy.store.entity.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressServiceTests {

    @Autowired
    private IAddressService addressService;

    @Autowired
    private IDistrictService districtService;

    @Test
    public void addNewAddress(){

        Address address = new Address();
        address.setPhone("29999999");
        address.setName("Tim");
        addressService.addNewAddress(8, "admin", address);
    }

    @Test
    public void getByParent(){
        List<District> list = districtService.getByParent("86");
        for (District d: list){
            System.err.println(d);
        }
    }

    @Test
    public void getByUid(){
        List<Address> list = addressService.getByUid(8);
        for (Address d: list){
            System.err.println(d);
        }
    }

    @Test
    public void setDefault(){
        addressService.setDefault(8, 8, "admin");
    }
}
