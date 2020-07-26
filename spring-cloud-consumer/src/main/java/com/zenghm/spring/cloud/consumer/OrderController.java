package com.zenghm.spring.cloud.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Create date:20/7/26.
 * Created by: zhm.
 * Class name:OrderController.
 */
@RestController
public class OrderController {
    private static final List<OrderInfo> ORDER_INFO_LIST = new ArrayList<>();

    @Autowired
    private RestTemplate restTemplate;
    /**
     * 下单接口 ，
     * @param productName
     * @param num
     * @return
     */
    @GetMapping("/order")
    public String order(String productName,Integer num){
        if(!StringUtils.isEmpty(productName)){
            ORDER_INFO_LIST.add(new OrderInfo(productName,num));

            //调用服务提供
            String result = restTemplate.getForObject("http://spring-cloud-provider/updateProduct?productName="+productName+"&num="+num,String.class);
            return result;
        }
        return null;
    }
}
