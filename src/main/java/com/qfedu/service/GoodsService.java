package com.qfedu.service;

import com.qfedu.pojo.Goods;

import java.util.List;

public interface GoodsService {
    Goods selectGoodsById(Integer id);

    List<Goods> selectAllGoodsByCid(Integer cid);

}
