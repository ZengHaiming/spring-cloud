package com.zenghm.spring.cloud.extend.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author Airlen
 * @date 2021/4/18
 * @description spring boot 异步执行
 */
@Component
public class CustomApplicationRunner implements ApplicationRunner {
    private Logger logger = LoggerFactory.getLogger(CustomApplicationRunner.class);
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        logger.info("ApplicationRunner 被执行");
    }
}
