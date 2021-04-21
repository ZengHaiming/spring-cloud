package com.zenghm.spring.cloud.extend.bean.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;
import java.beans.PropertyDescriptor;

/**
 * @author Airlen
 * @date 2021/4/18
 * @description bean 初始化过程
 */
@Component
public class CustomBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    private Logger logger = LoggerFactory.getLogger(CustomBeanPostProcessor.class);
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("{} bean 属性初始化之前,对象{}",beanName,bean);
        //返回空会导致启动失败
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("{} bean 属性初始化之后,对象{}",beanName,bean);
        //返回空会导致启动失败
        return bean;
    }


    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        logger.info("postProcessBeforeInstantiation");
        return null;
    }


    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        logger.info("postProcessAfterInstantiation");
        return false;
    }


    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs,
                                                    PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        logger.info("postProcessPropertyValues");
        return pvs;
    }
}
