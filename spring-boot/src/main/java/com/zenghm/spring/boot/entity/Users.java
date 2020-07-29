package com.zenghm.spring.boot.entity;

/**
 * Create date:20/7/29.
 * Created by: zhm.
 * Class name:Users.
 */

public class Users {
    private String name;
    private String password;
    private Boolean isactive;

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

    public Boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(Boolean isactive) {
        this.isactive = isactive;
    }
}
