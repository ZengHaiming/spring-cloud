package com.zenghm.spring.cloud.provider;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Create date:20/7/26.
 * Created by: zhm.
 * Class name:ProductController.
 */
@RestController
public class ProductController {
    private static final Map<String,Integer> productMap = new HashMap<>();
    @GetMapping("/updateProduct")
    public String updateProduct(String productName,Integer num){
        if(!StringUtils.isEmpty(productName)){
            productMap.put(productName,(productMap.get(productName)==null?0:productMap.get(productName)-num));
            System.out.println("修改库存：productName-"+productName+",num-"+num);
        }
        return "修改库存成功，"+productName+"剩余库存:"+productMap.get(productName);
    }
}
