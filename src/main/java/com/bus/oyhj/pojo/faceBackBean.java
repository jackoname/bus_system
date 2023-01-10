package com.bus.oyhj.pojo;

import java.util.Date;

public class faceBackBean {
    private String userid;
    private String message,dt;
    private Date time;
    private int id;

    public faceBackBean() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public faceBackBean(String userid, String message) {
        this.userid = userid;
        this.message = message;
        this.time = new Date();
    }
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "faceBackBean{" +
                "userid=" + userid +
                ", message='" + message + '\'' +
                ", time=" + time +
                '}';
    }
}
