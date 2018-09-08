package com.qfedu.web.controller;

import com.qfedu.pojo.Category;
import com.qfedu.pojo.vo.QueryVo;
import com.qfedu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CategoryController extends BaseController{

    @Autowired
    private CategoryService service;

    ////查询所有一级商品类型
    //@RequestMapping(value = "/allparentcategory.do",method = RequestMethod.GET)
    //public @ResponseBody
    //QueryVo selectParentCate() {
    //    QueryVo queryVo = new QueryVo();
    //    List<Category> categories = service.selectParentCate();
    //    boolean flag = categories.size()>0;
    //    queryVo.setCode(flag? 1000 : 1001);
    //    queryVo.setMsg(flag ? "success" : "error");
    //    queryVo.setData(flag ? categories : null);
    //    return queryVo;
    //}
    ////根据parentid查询对应的子商品类型
    //@RequestMapping(value = "/allsoncategory.do",method = RequestMethod.GET)
    //public @ResponseBody
    //QueryVo selectSonCateByParentid(@RequestParam Integer  parentid){
    //    System.out.println(parentid);
    //    QueryVo queryVo = new QueryVo();
    //    List<Category> categories = service.selectSonCateByParentid(parentid);
    //   boolean flag = categories.size()>0;
    //   queryVo.setCode(flag?1000:1001);
    //   queryVo.setMsg(flag?"success":"error");
    //    queryVo.setData(flag?categories:null);
    //    return queryVo;
    //}

    //查询所有商品类型
    @RequestMapping(value = "/allcategory.do",method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody QueryVo selectAllCate(HttpSession session) {
        List<Category> cate = getCate(session);
        boolean re = cate.size()>0;
        QueryVo queryVo = new QueryVo();
        queryVo.setCode(re?1000:1001);
        queryVo.setMsg(re?"success":"error");
        queryVo.setData(re?cate:null);
        return queryVo;
    }

    //当前会话生成一个categories;
    public List<Category> getCate(HttpSession session){
        List<Category> categories= (List<Category>) session.getServletContext().getAttribute("categories");
        if(categories==null){
            categories = service.selectAllCate();
            session.getServletContext().setAttribute("categories",categories);
            return categories;
        }
        return categories;
    }
}
