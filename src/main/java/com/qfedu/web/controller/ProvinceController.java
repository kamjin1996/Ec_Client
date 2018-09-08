package com.qfedu.web.controller;

import com.qfedu.pojo.City;
import com.qfedu.pojo.County;
import com.qfedu.pojo.Province;
import com.qfedu.pojo.vo.QueryVo;
import com.qfedu.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProvinceController extends BaseController{
    @Autowired
    private ProvinceService provinceService;

    @RequestMapping("/provincelist.do")
    public @ResponseBody QueryVo queryPro(HttpSession session){
        QueryVo queryVo = new QueryVo();
        session.setAttribute("provincies", provinceService.QueryAllPro());
        queryVo.setCode(1000);
        return queryVo;
    }
    @RequestMapping("/citylist.do")
    public @ResponseBody List<City> queryCity(int pid, Model model){
        return provinceService.QueryAllCityByPid(pid);
    }

    @RequestMapping("/countylist.do")
    public @ResponseBody List<County> queryCounty(int cityid,Model model){
        return provinceService.QueryAllCountyByCity(cityid);
    }
}
