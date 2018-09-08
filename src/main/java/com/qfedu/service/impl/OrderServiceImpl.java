package com.qfedu.service.impl;

import com.qfedu.mapper.OrderItemMapper;
import com.qfedu.mapper.OrderMapper;
import com.qfedu.pojo.CartItem;
import com.qfedu.pojo.Order;
import com.qfedu.pojo.OrderItem;
import com.qfedu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper itemMapper;

    @Override
    public boolean saveOrder(Integer rid, int money,List<CartItem> cartItems,int uid) {
        //保存订单
        Order order = new Order();
        order.setUid(uid);
        order.setRid(rid);
        //新生成订单项。未支付
        order.setFlag(0);
        //本地保存的是分
        order.setMoney(money);
        int oid = orderMapper.insert(order);
        //保存订单项
            for(int i = 0;i<cartItems.size();i++){
                OrderItem orderItem = new OrderItem();
                orderItem.setCount(cartItems.get(i).getCount());

                orderItem.setOid(oid);
                orderItem.setGid(cartItems.get(i).getGid());
                itemMapper.insert(orderItem);
                cartItems.remove(i);
            }
        return oid>0;
    }

    @Override
    public List<Order> queryOrderListByUid(Integer uid) {
        return  orderMapper.selectByUid(uid);
    }
}
