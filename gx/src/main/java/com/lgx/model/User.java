package com.lgx.model;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import com.lgx.common.BaseModel;

public class User extends BaseModel{

    private static final long serialVersionUID = 3074678213015096242L;
    @NotEmpty
    private String name;
    
    private String password;
    
    private String email;
    
    private Date lastLoginTime;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getLastLoginTime() {
        return lastLoginTime;
    }
    public void setLastLoginTime(Date lastLoginTime) {
        lastLoginTime = lastLoginTime;
    }
}
