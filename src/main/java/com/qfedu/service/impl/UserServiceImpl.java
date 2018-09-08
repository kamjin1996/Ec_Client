package com.qfedu.service.impl;

import com.qfedu.mapper.CartMapper;
import com.qfedu.mapper.UserMapper;
import com.qfedu.pojo.Cart;
import com.qfedu.pojo.User;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;
    @Autowired
    private CartMapper cartMapper;

    @Override
    public User userLogin(String username, String password) {
        if (username != null && !"".equals(username)&&password!=null && !"".equals(password)) {
        User user = mapper.selectByName(username);
        if(user!=null){
            if(Objects.equals(user.getPassword(), password)){
                return user;
            }
        } else {
            return null;
        }
            }
            return null;
    }


    @Override
    public boolean checkusername(String username) {
        return mapper.selectByName(username) != null;
    }



    @Override
    public boolean userRegister(User user) {
        if (user != null) {
            String username = user.getUsername();
            String password = user.getPassword();
            if (username != null && !"".equals(username) && password != null && !"".equals(password)) {
                user.setFlag(0);
                int id = mapper.insert(user);
                Cart cart = new Cart();
                cart.setUid(id);
                cartMapper.insert(cart);
                return id>0;
            }
        }
        return false;
    }

}
