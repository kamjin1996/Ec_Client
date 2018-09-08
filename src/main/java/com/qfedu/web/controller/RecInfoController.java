package com.qfedu.web.controller;

import com.qfedu.pojo.RecInfo;

import com.qfedu.pojo.User;
import com.qfedu.pojo.vo.QueryVo;
import com.qfedu.service.RecInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class RecInfoController extends BaseController{

    @Autowired
    private RecInfoService recInfoService;

    //修改recinfo
    @RequestMapping(value = "/updaterecinfo.do", method = RequestMethod.POST)
    public @ResponseBody
    QueryVo update(RecInfo recInfo) {
        QueryVo vo = new QueryVo();
        if (recInfoService.updateRecinfoActiveById(recInfo)) {
            vo.setCode(1000);
        } else {
            vo.setCode(1001);
        }
        return vo;
    }


    //添加recinfo
    @RequestMapping(value = "/addrecinfo.do")
    public String addrecinfo(RecInfo recInfo, int countyid, int pid, HttpSession session) {
        recInfo.setCounyid(countyid);
        recInfo.setProid(pid);
        User user = (User) session.getAttribute("user");
        recInfo.setUid(user.getId());
        return recInfoService.addrecinfo(recInfo) ? "recinfolist.do?method=add" : "error.jsp";
    }

    //查询当前用户的所有recinfo
    @RequestMapping("/recinfolist.do")
    public @ResponseBody
    QueryVo select(HttpSession session, String method, HttpServletResponse response) throws IOException {
        QueryVo queryVo = new QueryVo();
        User user = (User) session.getAttribute("user");
        List<RecInfo> recinfos = recInfoService.queryByUser(user.getId());
        session.setAttribute("recinfos", recinfos);
        if ("add".equals(method) && method != null || "del".equals(method) && method != null) {
            //表示是添加方法或者删除请求的，刷新当前页面
            response.sendRedirect("self_info.jsp");
        }
        if (recinfos.size() > 0) {
            queryVo.setCode(1000);
        } else {
            queryVo.setCode(1001);
        }
        return queryVo;
    }

    //修改默认地址。
    @RequestMapping(value = "/defaultrecinfo.do", method = RequestMethod.POST)
    public @ResponseBody
    QueryVo changeDefaultRecInfo(int id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        QueryVo vo = new QueryVo();
        if (recInfoService.updateFlagByidOrUid(id, user.getId())) {
            vo.setCode(1000);
        } else {
            vo.setCode(1001);
        }
        return vo;
    }

    //删除收货地址
    @RequestMapping("/deleterecinfo.do")
    public @ResponseBody
    String
    delectRecInfo(int id, HttpServletResponse response) {
        if (recInfoService.deleteRecInfoById(id)) {
            return "recinfolist.do?method=del";
        } else {
            return "error.jsp";
        }

    }
}
