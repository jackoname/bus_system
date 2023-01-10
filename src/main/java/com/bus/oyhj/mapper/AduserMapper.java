package com.bus.oyhj.mapper;
import com.bus.oyhj.pojo.admitBean;
import com.bus.oyhj.pojo.faceBackBean;
import com.bus.oyhj.pojo.noticeBean;
import com.bus.oyhj.pojo.userBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AduserMapper {
    List<admitBean>queryUserList();
    List<admitBean>loginUser(admitBean admitBean);
   boolean delUser(userBean userBean);
    boolean addNotice(noticeBean noticeBean);
    List<faceBackBean>allAdvice();
}
