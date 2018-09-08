package com.qfedu.mapper;

import com.qfedu.pojo.User;

public interface UserMapper {

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    User selectByName(String username);
}