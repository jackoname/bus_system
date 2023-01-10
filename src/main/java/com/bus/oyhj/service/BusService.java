package com.bus.oyhj.service;

import com.bus.oyhj.pojo.busBean;
import com.bus.oyhj.pojo.busStationBean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public interface BusService {
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
