package com.cy.store.service;

import com.cy.store.entity.Address;

import java.util.List;

public interface IAddressService {

    void addNewAddress(Integer uid, String username, Address address);

    List<Address> getByUid(Integer uid);
}
