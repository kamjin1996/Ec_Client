package com.qfedu.service.impl;

import com.qfedu.mapper.CartItemMapper;
import com.qfedu.mapper.CartMapper;
import com.qfedu.pojo.Cart;
import com.qfedu.pojo.CartItem;
import com.qfedu.pojo.Goods;
import com.qfedu.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private CartItemMapper cartItemMapper;

    //加入一件商品到购物车
    @Override
    public boolean saveCarts(int gid, Cart cart,int count) {

        CartItem cartItem = new CartItem();
        cartItem.setCartid(cart.getId());
        //count至少为1
        if(count==0){
            cartItem.setCount(1);
        } else {
            cartItem.setCount(count);
        }

        cartItem.setGid(gid);
        return cartItemMapper.insert(cartItem)>0;
    }

    @Override
    public Cart selectMyCart(Integer uid) {
        return cartMapper.selectByUid(uid);
    }

    @Override
    public List<CartItem> selectCartItemByCid(Integer cid) {
        return cartItemMapper.selectByCid(cid);
    }
}
