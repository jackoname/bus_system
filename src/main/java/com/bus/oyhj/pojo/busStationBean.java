package com.bus.oyhj.pojo;

public class busStationBean {
    private Integer buspointson,orders,busid;

    private String  stationname;

    public busStationBean() {

    }

    public busStationBean( Integer orders, Integer busid, String stationname) {

        this.orders = orders;
        this.busid = busid;
        this.stationname = stationname;
    }

    public Integer getBuspointson() {
        return buspointson;
    }

    public void setBuspointson(Integer buspointson) {
        this.buspointson = buspointson;
    }

    public Integer getOrder() {
        return orders;
    }

    public void setOrder(Integer order) {
        this.orders = order;
    }

    public Integer getBusid() {
        return busid;
    }

    public void setBusid(Integer busid) {
        this.busid = busid;
    }

    public String getStationname() {
        return stationname;
    }

    public void setStationname(String stationname) {
        this.stationname = stationname;
    }

    @Override
    public String toString() {
        return  + buspointson+" "+
                " 站点名: " + stationname + '\'' +
                "  第几站: " + orders +
                " 所属公车: " + busid
               ;
    }
}
