package com.qfedu.service;

import com.qfedu.pojo.RecInfo;

import java.util.List;

public interface RecInfoService {
    boolean addrecinfo(RecInfo recInfo);

    List<RecInfo> queryByUser(int uid);

    boolean updateFlagByidOrUid(int id,int uid);

    boolean deleteRecInfoById(int id);

    boolean updateRecinfoActiveById(RecInfo recInfo);
}
