package com.qfedu.web.controller;

import com.qfedu.pojo.*;
import com.qfedu.pojo.vo.QueryVo;
import com.qfedu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController extends BaseController{
    @Autowired
    private OrderService orderService;

    //orderlist.do
    @RequestMapping("/orderlist.do")
    public @ResponseBody
    QueryVo queryOrderList(HttpSession session){
        QueryVo queryVo = new QueryVo();
        queryVo.setCode(1000);
       User user = (User) session.getAttribute("user");
        List<Order> orderlist = orderService.queryOrderListByUid(user.getId());
        session.setAttribute("orderlist",orderlist);
        return queryVo;
    }


    //saveorder
    @RequestMapping(value = "/addorder.do",method = RequestMethod.POST)
    public String saveOrder(int rid,Double money, HttpSession session){
        User user =  (User)session.getAttribute("user");
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartitems");
        orderService.saveOrder(rid,money.intValue(),cartItems,user.getId());
        return "orderlist.do";
    }

}
