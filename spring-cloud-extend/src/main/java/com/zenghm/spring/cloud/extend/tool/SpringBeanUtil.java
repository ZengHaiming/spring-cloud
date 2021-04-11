package com.zenghm.spring.cloud.extend.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author Airlen
 * @date 2021/4/11
 * @description 获取spring 容器中的bean 工具类，通过获取spring 容器上下文获取bean
 */
@Component
public class SpringBeanUtil implements ApplicationContextAware {
    Logger logger = LoggerFactory.getLogger(SpringBeanUtil.class);
    ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        logger.info("注入Spring上下文");
    }

    public <T> T getBean(String name) {
        return getBean(name, this.applicationContext);
    }

    private <T> T getBean(String name, ApplicationContext context) {
        return context.getBean(name) == null ? (context.getParent() == null ? null : getBean(name, context.getParent())) : (T) context.getBean(name);
    }
}
