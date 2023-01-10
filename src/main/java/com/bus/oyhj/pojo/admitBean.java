package com.bus.oyhj.pojo;

public class admitBean {

    private String admitpassword,admitid;

    public admitBean() {
    }

    public admitBean(String admitpassword, String admitid) {
        this.admitpassword = admitpassword;
        this.admitid = admitid;
    }

    public String getAdmitpassword() {
        return admitpassword;
    }

    public void setAdmitpassword(String admitpassword) {
        this.admitpassword = admitpassword;
    }

    public String getAdmitid() {
        return admitid;
    }

    public void setAdmitid(String admitid) {
        this.admitid = admitid;
    }

    @Override
    public String toString() {
        return "admitBean{" +
                "admitpassword='" + admitpassword + '\'' +
                ", admitid='" + admitid + '\'' +
                '}';
    }
}
