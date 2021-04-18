package com.zenghm.spring.cloud.extend.dto;

import com.zenghm.spring.cloud.extend.constent.ENSex;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Airlen
 * @date 2021/4/18
 * @description xxx
 */

public class RequestDto implements Serializable {
    String name;
    Integer age;
    Boolean isworke;
    ENSex sex;
    Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getIsworke() {
        return isworke;
    }

    public void setIsworke(Boolean isworke) {
        this.isworke = isworke;
    }

    public ENSex getSex() {
        return sex;
    }

    public void setSex(ENSex sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
