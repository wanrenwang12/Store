package com.cy.store.service.impl;

import com.cy.store.entity.Address;
import com.cy.store.mapper.AddressMapper;
import com.cy.store.service.IAddressService;
import com.cy.store.service.IDistrictService;
import com.cy.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {

    @Resource
    private AddressMapper addressMapper;

    @Resource
    private IDistrictService districtService;


    @Value("${user.address.max-count}")
    private Integer maxCount;

    @Override
    public void addNewAddress(Integer uid, String username, Address address) {
        Integer count = addressMapper.countByUid(uid);
        if (count >= maxCount){
            throw new AddressCountLimitException("Sorry, your have owned exceed address");
        }

        String provinceName = districtService.getNameByCode(address.getProvinceCode());
        String cityName = districtService.getNameByCode(address.getCityCode());
        String areaName = districtService.getNameByCode(address.getAreaCode());
        address.setProvinceName(provinceName);
        address.setCityName(cityName);
        address.setAreaName(areaName);

        address.setUid(uid);
        Integer isDefault = count == 0? 1:0;
        address.setIsDefault(isDefault);
        address.setCreatedUser(username);
        address.setCreatedTime(new Date());
        address.setModifiedUser(username);
        address.setModifiedTime(new Date());

        Integer rows = addressMapper.insert(address);
        if (rows != 1){
            throw new InsertException("fail to insert");
        }
    }

    @Override
    public List<Address> getByUid(Integer uid) {
        List<Address> list = addressMapper.findByUid(uid);
        for(Address address : list){
            //address.setUid(null);
            //address.setAid(null);
            address.setProvinceCode(null);
            address.setCityCode(null);
            address.setAreaCode(null);
            address.setTel(null);
            address.setIsDefault(null);
            address.setCreatedTime(null);
            address.setCreatedUser(null);
            address.setModifiedTime(null);
            address.setModifiedUser(null);
        }
        return list;
    }

    @Override
    public void setDefault(Integer aid, Integer uid, String username) {
        Address result = addressMapper.findByAid(aid);
        if (result == null){
            throw new AddressNotFoundException("address not exist");
        }
        if (!result.getUid().equals(uid)){
            throw new AccessDeniedException("Denied access");
        }

        addressMapper.updateNonDefault(uid);
        Integer rows = addressMapper.updateDefaultByAid(aid, username, new Date());
        if (rows != 1){
            throw new UpdateException("fail to update");
        }

    }

    @Override
    public void deleteAddress(Integer aid, Integer uid, String username) {
        Address result = addressMapper.findByAid(aid);
        if (result == null){
            throw new AddressNotFoundException("address not exist");
        }
        if (!result.getUid().equals(uid)){
            throw new AccessDeniedException("Denied access");
        }
        Integer rows = addressMapper.deleteByAid(aid);
        if (rows != 1){
            throw new DeleteException("fail to delete");
        }

        if (result.getIsDefault() == 0){
            return;
        }

        Integer count = addressMapper.countByUid(uid);
        if (count == 0){
            return;
        }

        Address address = addressMapper.findLastModified(uid);
        rows = addressMapper.updateDefaultByAid(address.getAid(), username, new Date());
        if (rows != 1){
            throw new UpdateException("fail to update");
        }
    }
}
