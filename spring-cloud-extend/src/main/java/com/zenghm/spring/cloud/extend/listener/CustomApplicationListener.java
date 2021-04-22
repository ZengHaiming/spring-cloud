package com.zenghm.spring.cloud.extend.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author Airlen
 * @date 2021/4/18
 * @description spring  event 监听者 ,处理spring event
 */
@Component
public class CustomApplicationListener implements ApplicationListener {
    private Logger logger = LoggerFactory.getLogger(CustomApplicationListener.class);
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        logger.info("执行Spring 监听事件：{}", event.getClass().getName());
    }
}
