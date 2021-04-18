package com.zenghm.spring.cloud.extend.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author Airlen
 * @date 2021/4/18
 * @description 环境变量获取工具类
 */
@Component
public class SpringEnvUtil implements EnvironmentAware {
    private static Logger logger = LoggerFactory.getLogger(SpringBeanUtil.class);
    private static Environment environment;
    /**
     * Set the {@code Environment} that this component runs in.
     *
     * @param env
     */
    @Override
    public void setEnvironment(Environment env) {
        environment = env;
    }

    public static Environment getEnvironment() {
        return environment;
    }
}
