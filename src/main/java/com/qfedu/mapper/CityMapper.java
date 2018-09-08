package com.qfedu.mapper;

import com.qfedu.pojo.City;

import java.util.List;

public interface CityMapper {

    List<City> selectAllByPid(int pid);
}