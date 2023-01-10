package com.bus.oyhj.mapper;

import com.bus.oyhj.pojo.busBean;
import com.bus.oyhj.pojo.busStationBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
@Mapper
@Repository
public interface BusMapper {
    List<busBean> queryUserList();
    List<busStationBean> queryUserListSta();
    List<busBean> queryUserListbyId(int busid);
    List<busStationBean> queryUserListbySid(int busid);
    List<busBean> queryUserListByinf(busBean busBeans);
    boolean addBus(busBean busBeans);
    boolean addBusStations(busStationBean busBeans);
    boolean updateStaBadd(busStationBean busBeans);
    boolean updateStaBdel(busStationBean busBeans);
    boolean delBusStations(busStationBean busBeans);
    boolean updateSta(busStationBean busBeans);
    boolean updateBus(busBean busBeans);
    boolean delBus(busBean busBeans);
    boolean updateBusbe(busBean busBeans);
}
