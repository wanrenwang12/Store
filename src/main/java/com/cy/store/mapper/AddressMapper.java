package com.cy.store.mapper;

import com.cy.store.entity.Address;

import java.util.Date;
import java.util.List;

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

    /**
     * select address
     * @param uid
     * @return all address
     */
    List<Address> findByUid(Integer uid);

    /**
     * select address by aid
     * @param aid
     * @return address
     */
    Address findByAid(Integer aid);

    /**
     * set  all isDefault as 0
     * @param uid
     * @return rows been influenced
     */
    Integer updateNonDefault(Integer uid);

    /**
     * update a default
     * @param aid
     * @return rows been influenced
     */
    Integer updateDefaultByAid(Integer aid, String modifiedUser, Date modifiedTime);

}
