package com.bus.oyhj.service.imp;

import com.bus.oyhj.mapper.AduserMapper;
import com.bus.oyhj.pojo.admitBean;
import com.bus.oyhj.pojo.faceBackBean;
import com.bus.oyhj.pojo.noticeBean;
import com.bus.oyhj.pojo.userBean;
import com.bus.oyhj.service.AduserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class aduserServiceimp implements AduserService {
    @Autowired
    private AduserMapper aduserMapper;
    @Override
    public List<admitBean> queryUserList() {
        return aduserMapper.queryUserList();
    }

    @Override
    public List<admitBean> loginUser(admitBean admitBean) {
        return aduserMapper.loginUser(admitBean);
    }

    @Override
    public boolean delUser(userBean userBean) {
        return aduserMapper.delUser(userBean);
    }

    @Override
    public boolean addNotice(noticeBean noticeBean) {
        return aduserMapper.addNotice(noticeBean);
    }
    @Override
    public List<faceBackBean> allAdvice() {
        return aduserMapper.allAdvice();
    }
}
