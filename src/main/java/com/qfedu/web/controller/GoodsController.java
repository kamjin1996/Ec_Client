package com.qfedu.web.controller;

import com.qfedu.pojo.Goods;
import com.qfedu.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Controller
public class GoodsController extends BaseController{

    @Autowired
    private GoodsService service;

    //selectAllGoods
    @RequestMapping(value = "/goodslist.do",method = RequestMethod.GET)
    public String selectAllGoods(@RequestParam("id") Integer cid,Model model){
        List<Goods> goodsList =service.selectAllGoodsByCid(cid);
        model.addAttribute("glist",goodsList);
        return "goodsList.jsp";
    }

    //getGoodsById
    @RequestMapping("/getGoodsById.do")
    public String selectGoodsById(Integer id,Model model){
        model.addAttribute("goods",service.selectGoodsById(id));
        return "goodsDetail.jsp";
    }

}
