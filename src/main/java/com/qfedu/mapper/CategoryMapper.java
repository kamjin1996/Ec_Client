package com.qfedu.mapper;

import com.qfedu.pojo.Category;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> selectAllactive(Category category);

    List<Category> selectAll();

    List<Category> selectAllSonCate(Integer parentid);

    List<Category> selectParentCate(int level);
}