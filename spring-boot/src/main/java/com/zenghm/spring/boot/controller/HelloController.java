package com.zenghm.spring.boot.controller;

import com.zenghm.spring.boot.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create date:20/7/28.
 * Created by: zhm.
 * Class name:HelloController.
 */
@RestController
public class HelloController {
    //自动配置实现注入
    //ConfigurationProperties 自动配置添加了该注解的对象的属性
    //ConditionalOnClass 过滤条件 , 对应的类在classpath 中存在才生效 , 否则自动装配不生效
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private Person person;
    @RequestMapping("/name")
    public String name(){
        System.out.println("jdbcTemplate:"+jdbcTemplate);
        return "Spring Boot";
    }

    //配置自动配置属性测试类
    @RequestMapping("/getPerson")
    public String getPerson(){
        System.out.println("Person:"+person);
        return String.format("name:%s,age:%s！",person.getName(),person.getAge());
    }
}
