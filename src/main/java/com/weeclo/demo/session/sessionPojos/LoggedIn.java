package com.weeclo.demo.session.sessionPojos;

import com.weeclo.demo.entities.UserEntity;

import java.io.Serializable;
import java.sql.Date;

public class LoggedIn implements Serializable{
    private String recentIP;
    private Long lastAccessedTime;
    private UserEntity user;
    private boolean active;


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRecentIP() {
        return recentIP;
    }

    public void setRecentIP(String recentIP) {
        this.recentIP = recentIP;
    }

    public Long getLastAccessedTime() {
        return lastAccessedTime;
    }

    public void setLastAccessedTime(Long lastAccessedTime) {
        this.lastAccessedTime = Long.valueOf(lastAccessedTime);
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

}
