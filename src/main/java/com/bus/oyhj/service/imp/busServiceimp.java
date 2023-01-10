package com.bus.oyhj.service.imp;

import com.bus.oyhj.mapper.BusMapper;
import com.bus.oyhj.pojo.busBean;
import com.bus.oyhj.pojo.busStationBean;
import com.bus.oyhj.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class busServiceimp implements BusService {
    @Autowired
    private BusMapper busMapper;
    @Override
    public List<busBean> queryUserList() {
        return busMapper.queryUserList();
    }

    @Override
    public List<busStationBean> queryUserListSta() {
        return busMapper.queryUserListSta();
    }

    @Override
    public List<busBean> queryUserListbyId(int busid) {
        return busMapper.queryUserListbyId(busid);
    }

    @Override
    public List<busStationBean> queryUserListbySid(int busid) {
        return busMapper.queryUserListbySid(busid);
    }

    @Override
    public List<busBean> queryUserListByinf(busBean busBeans) {
        return busMapper.queryUserListByinf(busBeans);
    }

    @Override
    public boolean addBus(busBean busBeans) {
        return busMapper.addBus(busBeans);
    }

    @Override
    public boolean addBusStations(busStationBean busBeans) {

        return busMapper.addBusStations(busBeans);
    }

    @Override
    public boolean updateStaBadd(busStationBean busBeans) {
        return busMapper.updateStaBadd(busBeans);
    }

    @Override
    public boolean updateStaBdel(busStationBean busBeans) {
        return busMapper.updateStaBdel(busBeans);
    }

    @Override
    public boolean delBusStations(busStationBean busBeans) {
        return busMapper.delBusStations(busBeans);
    }

    @Override
    public boolean updateSta(busStationBean busBeans) {

        System.out.println(busBeans.getBusid());
        return busMapper.updateSta(busBeans);  }

    @Override
    public boolean updateBus(busBean busBeans) {
        return busMapper.updateBus(busBeans);
    }

    @Override
    public boolean delBus(busBean busBeans) {
        return busMapper.delBus(busBeans);
    }

    @Override
    public boolean updateBusbe(busBean busBeans) {
        return busMapper.updateBusbe(busBeans);
    }

}
