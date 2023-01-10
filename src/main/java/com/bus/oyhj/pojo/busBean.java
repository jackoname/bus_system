package com.bus.oyhj.pojo;

import java.util.Date;

public class busBean {
    private Integer busid;

    private String begin,end,busno;
    private String busbgo,busego;

    public busBean() {
    }

    public String getBusno() {
        return busno;
    }

    public void setBusno(String busno) {
        this.busno = busno;
    }
    public busBean(Integer busid, String begin, String end) {
        this.busid = busid;
        this.begin = begin;
        this.end = end;

    }
    public busBean(Integer busid, String begin, String end, String busbgo, String busego, String busno) {
        this.busid = busid;
        this.begin = begin;
        this.end = end;
        this.busbgo = busbgo;
        this.busego = busego;
        this.busno=busno;
    }

    public Integer getBusid() {
        return busid;
    }

    public void setBusid(Integer busid) {
        this.busid = busid;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getBusbgo() {
        return busbgo;
    }

    public void setBusbgo(String busbgo) {
        this.busbgo = busbgo;
    }

    public String getBusego() {
        return busego;
    }

    public void setBusego(String busego) {
        this.busego = busego;
    }

    @Override
    public String toString() {
        return "busBean{" +
                "busid=" + busid +
                ", begin='" + begin + '\'' +
                ", end='" + end + '\'' +
                ", busbgo='" + busbgo + '\'' +
                ", busego='" + busego + '\'' +
                '}';
    }
}
