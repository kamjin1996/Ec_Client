package com.qfedu.service;

import com.qfedu.pojo.CartItem;
import com.qfedu.pojo.Order;

import java.util.List;

public interface OrderService {

    boolean saveOrder(Integer rid, int money, List<CartItem> cartItems,int uid);

    List<Order> queryOrderListByUid(Integer uid);
}
