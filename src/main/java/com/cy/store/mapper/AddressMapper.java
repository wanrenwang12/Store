package com.cy.store.mapper;

import com.cy.store.entity.Address;

public interface AddressMapper {

    /**
     * add address
     * @param address
     * @return number of rows be influenced
     */
    Integer insert(Address address);

    /**
     * get number of address
     * @param uid
     * @return num
     */
    Integer countByUid(Integer uid);

}
