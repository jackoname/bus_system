package com.bus.oyhj.mapper;


import com.bus.oyhj.pojo.busBean;
import com.bus.oyhj.pojo.faceBackBean;
import com.bus.oyhj.pojo.noticeBean;
import com.bus.oyhj.pojo.userBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<userBean>queryUserList();
    List<userBean>loginUser(userBean userBean);
    boolean addUser(userBean userBean);
    List<noticeBean> allNotice();
    boolean addAdvice(faceBackBean faceBackBean);
    boolean userNew(userBean userBean);
    boolean updateUser(userBean userBean);
}
