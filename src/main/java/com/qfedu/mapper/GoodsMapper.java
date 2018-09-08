package com.qfedu.mapper;

import com.qfedu.pojo.Goods;
import com.qfedu.pojo.vo.GoodsVo;

import java.util.List;

public interface GoodsMapper {


    Goods selectByPrimaryKey(Integer id);

    List<GoodsVo> selectAllactive(Goods goods);

    List<Goods> selectAllByCid(Integer cid);
}