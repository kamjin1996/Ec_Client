package com.qfedu.mapper;

import com.qfedu.pojo.Cart;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    Cart selectById(Integer id);

    Cart selectByUid(Integer uid);
}