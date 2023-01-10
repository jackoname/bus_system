package com.bus.oyhj.service;

import com.bus.oyhj.pojo.faceBackBean;
import com.bus.oyhj.pojo.noticeBean;
import com.bus.oyhj.pojo.userBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<userBean>queryUserList();
    List<userBean>loginUser(userBean userBean);
    boolean addUser(userBean userBean);
    List<noticeBean>allNotice();
    boolean addAdvice(faceBackBean faceBackBean);
    boolean userNew(userBean userBean);
    boolean updateUser(userBean userBean);
}
