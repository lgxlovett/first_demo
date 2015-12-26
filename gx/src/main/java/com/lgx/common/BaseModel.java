package com.lgx.common;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseModel implements Serializable{

    private static final long serialVersionUID = 1L;
    private String id;
    private int voidFlag;
    private String createUser;
    private Date createDate;
    private String updateUser;
    private Date updateDate;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getVoidFlag() {
        return voidFlag;
    }
    public void setVoidFlag(int voidFlag) {
        this.voidFlag = voidFlag;
    }
    public String getCreateUser() {
        return createUser;
    }
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public String getUpdateUser() {
        return updateUser;
    }
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    public Date getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

}
