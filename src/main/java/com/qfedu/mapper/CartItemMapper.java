package com.qfedu.mapper;

import com.qfedu.pojo.CartItem;

import java.util.List;

public interface CartItemMapper {


    int insert(CartItem record);


    List<CartItem> selectByCid(Integer cid);
}