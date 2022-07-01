package com.cy.store.mapper;

import com.cy.store.entity.District;

import java.util.List;

public interface DistrictMapper {

    /**
     * select all by parentID
     * @param parent
     * @return all area belong to the parent
     */
    List<District> findByParent(String parent);
}
