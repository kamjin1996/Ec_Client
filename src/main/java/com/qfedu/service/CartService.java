package com.qfedu.service;

import com.qfedu.pojo.Cart;
import com.qfedu.pojo.CartItem;

import java.util.List;

public interface CartService {
   boolean saveCarts(int gid, Cart cart,int count);

   Cart selectMyCart(Integer id);

   List<CartItem> selectCartItemByCid(Integer cid);
}
