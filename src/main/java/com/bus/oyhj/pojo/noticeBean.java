package com.bus.oyhj.pojo;

import java.util.Date;

public class noticeBean {
    private String admitid;
    private String message,dt;
    private Date time;
    private Integer id;
    public noticeBean() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdmitid() {
        return admitid;
    }

    public void setAdmitid(String admitid) {
        this.admitid = admitid;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public noticeBean(String admitid, String mesage) {
        this.admitid = admitid;
        this.message = message;
        this.time =new Date();
    }

    public String getAdmit() {
        return admitid;
    }

    public void setAdmit(String admitid) {
        this.admitid = admitid;
    }

    public String getMesage() {
        return message;
    }

    public void setMesage(String mesage) {
        this.message = mesage;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "noticeBean{" +
                "admit=" + admitid +
                ", mesage='" + message + '\'' +
                ", time=" + time +
                '}';
    }
}
