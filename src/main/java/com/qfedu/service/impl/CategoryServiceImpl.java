package com.qfedu.service.impl;


import com.qfedu.mapper.CategoryMapper;
import com.qfedu.pojo.Category;
import com.qfedu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper mapper;

    @Override
    public List<Category> selectAllCate(){
        return  mapper.selectAll();
    }

    @Override
    public List<Category> selectParentCate() {

        return mapper.selectParentCate(1);
    }

    @Override
    public List<Category> selectSonCateByParentid(Integer parentid) {

        return mapper.selectAllSonCate(parentid);
    }

}
