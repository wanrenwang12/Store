package com.cy.store.mapper;

import com.cy.store.entity.Cart;
import com.cy.store.vo.CartVO;

import java.util.Date;
import java.util.List;

public interface CartMapper {

    /**
     * insert into cart
     * @param cart
     * @return rows been influenced
     */
    Integer insert(Cart cart);

    /**
     * update num for cart
     * @param cid
     * @param num
     * @param modifiedUser
     * @param modifiedTime
     * @return rows been influenced
     */
    Integer updateNumByCid(Integer cid,
                           Integer num,
                           String modifiedUser,
                           Date modifiedTime);

    /**
     *
     * @param uid
     * @param pid
     * @return
     */
    Cart findByUidAndPid(Integer uid, Integer pid);


    List<CartVO> findVOByUid(Integer uid);

    Cart findByCid(Integer cid);

    Integer deleteCart(Integer cid);

    List<CartVO> findVOByCid(Integer[] cids);

    Integer deleteCartByCids(Integer[] cids);

}
