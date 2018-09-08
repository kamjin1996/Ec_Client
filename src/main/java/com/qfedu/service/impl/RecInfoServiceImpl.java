package com.qfedu.service.impl;

import com.qfedu.mapper.RecInfoMapper;
import com.qfedu.pojo.RecInfo;
import com.qfedu.pojo.User;
import com.qfedu.service.RecInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.Session;
import java.util.List;

@Service
public class RecInfoServiceImpl implements RecInfoService {

    @Autowired
    private RecInfoMapper recInfoMapper;

    @Override
    public boolean addrecinfo(RecInfo recInfo) {
        try {
              return recInfoMapper.insert(recInfo)>0;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateFlagByidOrUid(int id, int uid){
        recInfoMapper.updateFlagByUid(uid);
        return  recInfoMapper.updateFlagById(id,1)>0;
    }

    @Override
    public boolean deleteRecInfoById(int id) {
        return recInfoMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public boolean updateRecinfoActiveById(RecInfo recInfo) {
        return recInfoMapper.updateByPrimaryKeySelective(recInfo)>0;
    }


    @Override
    public List<RecInfo> queryByUser(int uid) {
        return recInfoMapper.selectByUid(uid);
    }
}
