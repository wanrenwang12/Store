package com.cy.store.service.impl;

import com.cy.store.entity.Cart;
import com.cy.store.entity.Product;
import com.cy.store.mapper.CartMapper;
import com.cy.store.mapper.ProductMapper;
import com.cy.store.service.ICartService;
import com.cy.store.service.ex.InsertException;
import com.cy.store.vo.CartVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CartServiceImpl implements ICartService {

    @Resource
    private CartMapper cartMapper;

    @Resource
    private ProductMapper productMapper;

    @Override
    public void addToCart(Integer uid, Integer pid, Integer amount, String username) {
        // check whether exist
        Cart result = cartMapper.findByUidAndPid(uid, pid);
        Date date = new Date();
        Integer rows = 0;
        if (result == null){
            Cart cart = new Cart();
            cart.setUid(uid);
            cart.setPid(pid);
            cart.setNum(amount);
            Product product = productMapper.findById(pid);
            cart.setPrice(product.getPrice());
            cart.setCreatedUser(username);
            cart.setCreatedTime(date);
            cart.setModifiedUser(username);
            cart.setModifiedTime(date);

            rows = cartMapper.insert(cart);
        } else{
            Integer num = result.getNum() + amount;
            rows = cartMapper.updateNumByCid(result.getCid(), num, username, date);
        }
        if (rows != 1){
            throw new InsertException("fail to insert");
        }
    }

    @Override
    public List<CartVO> getVOByUid(Integer uid) {
        return cartMapper.findVOByUid(uid);
    }
}
