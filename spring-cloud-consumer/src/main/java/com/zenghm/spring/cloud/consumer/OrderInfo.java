package com.zenghm.spring.cloud.consumer;

import java.io.Serializable;

/**
 * Create date:20/7/26.
 * Created by: zhm.
 * Class name:OrderInfo.
 */

public class OrderInfo implements Serializable{
    private String productName;
    private Integer num;

    public OrderInfo() {
    }

    public OrderInfo(String productName, Integer num) {
        this.productName = productName;
        this.num = num;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
