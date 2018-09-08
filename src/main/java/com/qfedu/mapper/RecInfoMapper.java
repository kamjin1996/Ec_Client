package com.qfedu.mapper;

import com.qfedu.pojo.RecInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RecInfo record);

    RecInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RecInfo record);

    List<RecInfo> selectByUid(Integer uid);

    int updateFlagById(@Param("id") int id,@Param("flag") int flag);

    int updateFlagByUid(int uid);
}