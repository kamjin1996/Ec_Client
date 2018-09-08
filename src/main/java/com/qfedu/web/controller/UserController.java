package com.qfedu.web.controller;

import com.qfedu.pojo.User;
import com.qfedu.pojo.vo.QueryVo;
import com.qfedu.service.CartService;
import com.qfedu.service.UserService;
import com.sun.xml.internal.ws.resources.HttpserverMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController extends BaseController{
    @Autowired
    private UserService service;

    @Autowired
    private CartService cartService;

    //用户登录
    @RequestMapping(value = "/userLogin.do", method = RequestMethod.POST)
    public String userLogin(HttpServletResponse response, String username, String password, HttpSession session, Model model) {
        User user = service.userLogin(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            Cookie uc = new Cookie("username", username);
            uc.setMaxAge(60 * 60 * 60);
            response.addCookie(uc);
            session.setAttribute("cart",cartService.selectMyCart(user.getId()));
            return "index.jsp";
        } else {
            model.addAttribute("msg", "登录失败请重试！");
            return "login.jsp";
        }
    }
    //userLogout
    @RequestMapping("/userLogout.do")
    public String loginOut(HttpSession session){
        session.removeAttribute("user");
        return "login.jsp";
    }



    //校验用户名是否存在
    @RequestMapping(value = "/checkusername.do", method = RequestMethod.GET)
    public @ResponseBody
    QueryVo checkusername(String username) {
        boolean flag = service.checkusername(username);
        QueryVo queryVo = new QueryVo();
        //1000已存在，1001不存在
        queryVo.setCode(flag ? 1000 : 1001);
        return queryVo;
    }

    @RequestMapping(value = "/userregister.do", method = RequestMethod.POST)
    public String userRegister(User user, Model model) {
        model.addAttribute("msg", "用户名或密码不合法，请重新注册！");
        return service.userRegister(user) ? "registerSuccess.jsp" : "register.jsp";
    }


}
