package com.qfedu.service.impl;

import com.qfedu.mapper.GoodsMapper;
import com.qfedu.pojo.Goods;
import com.qfedu.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper mapper;

    @Override
    public Goods selectGoodsById(Integer id) {
        Goods goods = mapper.selectByPrimaryKey(id);
        return goods;
    }

    @Override
    public List<Goods> selectAllGoodsByCid(Integer cid) {
        return  mapper.selectAllByCid(cid);
    }
}
