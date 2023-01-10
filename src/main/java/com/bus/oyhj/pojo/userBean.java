package com.bus.oyhj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class userBean {
    private Integer userid;
    private String username,userpassword,email;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public userBean( String username, String userpassword,String email) {
        this.email=email;
        this.username = username;
        this.userpassword = userpassword;

    }
    public userBean( String username, String userpassword) {
     
        this.username = username;
        this.userpassword = userpassword;

    }
    @Override
    public String toString() {
        return "userBean{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
