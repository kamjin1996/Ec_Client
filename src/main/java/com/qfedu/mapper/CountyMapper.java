package com.qfedu.mapper;

import com.qfedu.pojo.County;

import java.util.List;

public interface CountyMapper {

    List<County> selectAllByCityid(int cityid);
}