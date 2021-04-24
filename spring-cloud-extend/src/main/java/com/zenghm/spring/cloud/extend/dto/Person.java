package com.zenghm.spring.cloud.extend.dto;

import java.io.Serializable;

/**
 * @author Airlen
 * @date 2021/4/24
 * @description xxx
 */
public class Person implements Serializable {
    String name;
    Integer age;

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
}
