package com.bus.oyhj.service;


import com.bus.oyhj.pojo.admitBean;
import com.bus.oyhj.pojo.faceBackBean;
import com.bus.oyhj.pojo.noticeBean;
import com.bus.oyhj.pojo.userBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AduserService {
    List<admitBean>queryUserList();
    List<admitBean>loginUser(admitBean admitBean);
    boolean delUser(userBean userBean);
    boolean addNotice(noticeBean noticeBean);
    List<faceBackBean>allAdvice();
}
