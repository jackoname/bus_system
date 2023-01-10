package com.bus.oyhj.service.imp;

import com.bus.oyhj.mapper.UserMapper;
import com.bus.oyhj.pojo.faceBackBean;
import com.bus.oyhj.pojo.noticeBean;
import com.bus.oyhj.pojo.userBean;
import com.bus.oyhj.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class userServiceimp implements UserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public List<userBean> queryUserList() {
        return userMapper.queryUserList();
    }
    @Override
    public List<userBean> loginUser(userBean userBean) {
        System.out.println("服务层");
        return userMapper.loginUser(userBean);
    }

    @Override
    public boolean addUser(userBean userBean) {
        return  userMapper.addUser(userBean);
    }

    @Override
    public List<noticeBean> allNotice() {
        return userMapper.allNotice();
    }

    @Override
    public boolean addAdvice(faceBackBean faceBackBean) {
        return userMapper.addAdvice(faceBackBean);
    }

    @Override
    public boolean userNew(userBean userBean) {
        return userMapper.userNew(userBean);
    }

    @Override
    public boolean updateUser(userBean userBean) {
        return userMapper.updateUser(userBean);
    }
}
