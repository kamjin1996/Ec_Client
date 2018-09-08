package com.qfedu.web.controller;

import com.qfedu.pojo.Cart;
import com.qfedu.pojo.CartItem;
import com.qfedu.pojo.User;
import com.qfedu.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartController extends BaseController {

@Autowired
private CartService cartService;

    @RequestMapping("/addcart.do")
    public String add(int gid,HttpSession session){
        Cart cart = (Cart)session.getAttribute("cart");
        //直接从商品详情加入到购物车的商品默认count为1
        return cartService.saveCarts(gid, cart, 1)?"cartSuccess.jsp":"error.jsp";
    }

    //购物车列表cartlist查询
    @RequestMapping("/cartlist.do")
    public String cartList(HttpSession session){
        Cart cart = (Cart)session.getAttribute("cart");
        if(cart==null){
            return "login.jsp";
        }
        List<CartItem> cartitems =  cartService.selectCartItemByCid(cart.getId());
        session.setAttribute("cartitems",cartitems);
        return "cart.jsp";
    }
}
