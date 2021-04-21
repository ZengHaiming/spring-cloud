package com.zenghm.spring.cloud.extend.web.controller;

import com.zenghm.spring.cloud.extend.business.DemoService;
import com.zenghm.spring.cloud.extend.dto.RequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Airlen
 * @date 2021/4/21
 * @description xxx
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private DemoService demoService;
    @GetMapping("/doBusiness")
    public RequestDto test(){
        return demoService.doBusiness();
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}
