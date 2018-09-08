package com.qfedu.service;

import com.qfedu.pojo.City;
import com.qfedu.pojo.County;
import com.qfedu.pojo.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> QueryAllPro();
    List<City> QueryAllCityByPid(int pid);
    List<County> QueryAllCountyByCity(int cityid);
}
