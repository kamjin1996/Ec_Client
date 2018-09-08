package com.qfedu.service.impl;

import com.qfedu.mapper.CityMapper;
import com.qfedu.mapper.CountyMapper;
import com.qfedu.mapper.ProvinceMapper;
import com.qfedu.pojo.City;
import com.qfedu.pojo.County;
import com.qfedu.pojo.Province;
import com.qfedu.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiveImpl implements ProvinceService {
    @Autowired
    private ProvinceMapper provinceMapper;
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private CountyMapper countyMapper;


    @Override
    public List<Province> QueryAllPro() {
        return provinceMapper.selectAll();
    }

    @Override
    public List<City> QueryAllCityByPid(int pid) {
        return cityMapper.selectAllByPid(pid);
    }

    @Override
    public List<County> QueryAllCountyByCity(int cityid) {
        return countyMapper.selectAllByCityid(cityid);
    }
}
