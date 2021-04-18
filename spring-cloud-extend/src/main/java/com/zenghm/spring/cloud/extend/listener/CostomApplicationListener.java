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
public class CostomApplicationListener implements ApplicationListener {
    private Logger logger = LoggerFactory.getLogger(CostomApplicationListener.class);
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        logger.debug(event.getClass().getName());
    }
}
