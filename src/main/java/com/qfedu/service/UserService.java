package com.qfedu.service;

import com.qfedu.pojo.User;

public interface UserService {
    User userLogin(String username, String password);

    boolean checkusername(String username);

    boolean userRegister(User user);
}
