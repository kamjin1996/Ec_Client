package com.qfedu.service;

import com.qfedu.pojo.Category;

import java.util.List;

public interface CategoryService {
    List<Category> selectAllCate();

    List<Category> selectParentCate();

    List<Category> selectSonCateByParentid(Integer parentid);
}
