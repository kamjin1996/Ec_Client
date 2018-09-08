package com.qfedu.service.impl;

import com.qfedu.pojo.User;
import com.qfedu.service.ThreeLoginService;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThreeLoginServiceImpl implements ThreeLoginService {
    @Autowired
    private UserService userService;

    @Override
    public boolean ThreeLogin(String username, String password) {
        User user = userService.userLogin(username, password);
        if(user!=null){
            return true;
        } else {
            return false;
        }
    }
}
