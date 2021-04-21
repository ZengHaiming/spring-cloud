package com.zenghm.spring.cloud.extend.business.impl;

import com.zenghm.spring.cloud.extend.business.DemoService;
import com.zenghm.spring.cloud.extend.business.InjectionDemoService;
import com.zenghm.spring.cloud.extend.dto.RequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author Airlen
 * @date 2021/4/11
 * @description 演示 bean 的生命周期 ， bean 生命周期相关方法为堵塞
 */
@Service
public class DemoServiceImpl implements DemoService, BeanNameAware , InitializingBean, DisposableBean {
    private Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);
    @Autowired
    private InjectionDemoService injectionDemoService;

    @PostConstruct
    public void javaInit(){
        logger.info("执行Java注解PostConstruct方法");
    }

    @Override
    public void setBeanName(String name) {
        logger.info("类DemoServiceImpl当前bean名称：{}",name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("执行spring bean 初始化方法");
    }

    @Override
    public RequestDto doBusiness() {
        logger.info("执行业务");
        return injectionDemoService.doBusiness();
    }


    @Override
    public void destroy() throws Exception {
        logger.info("执行销毁方法");
    }

    @PreDestroy
    public void javaDestroy(){
        logger.info("执行java销毁方法");
    }


}
