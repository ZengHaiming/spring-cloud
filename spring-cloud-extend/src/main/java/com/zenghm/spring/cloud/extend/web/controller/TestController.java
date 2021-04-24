package com.zenghm.spring.cloud.extend.web.controller;

import com.zenghm.spring.cloud.extend.business.DemoService;
import com.zenghm.spring.cloud.extend.dto.Person;
import com.zenghm.spring.cloud.extend.dto.RequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.RequestParamMethodArgumentResolver;

import java.util.List;

/**
 * @author Airlen
 * @date 2021/4/21
 * @description xxx
 */
@RestController
@RequestMapping("/test")
public class TestController {
    private static Logger logger = LoggerFactory.getLogger(TestController.class);
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

    /**
     * 用逗号隔开  ,无需任何的处理可以解析成功
     * @param stringList
     * @return
     */
    @GetMapping("/listParamsTest")
    public String listParamsTest(@RequestParam("stringList") List<String> stringList){
        logger.info("接口的参数：{}",stringList);
        return "listParamsTest";
    }

    /**
     * has annotation {@link org.springframework.web.bind.annotation.RequestParam}
     *  will be intercepted by {@link RequestParamMethodArgumentResolver} , but {@link List<Person>} Cannot be parsed ,
     *  so not add annotation {@link RequestParam}
     * @param dtoList
     * @return
     */
    @RequestMapping("/dtoListParamsTest")
    public String dtoListParamsTest(List<Person> dtoList){
        logger.info("接口的参数：{}",dtoList);
        return "listParamsTest";
    }

}
