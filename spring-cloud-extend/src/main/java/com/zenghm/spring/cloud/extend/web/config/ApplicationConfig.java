package com.zenghm.spring.cloud.extend.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

/**
 * @author Airlen
 * @date 2021/4/18
 * @description xxx
 */
@Configuration
@ComponentScans({
        @ComponentScan("com.zenghm.spring.cloud.extend.bean"),
        @ComponentScan("com.zenghm.spring.cloud.extend.business"),
        @ComponentScan("com.zenghm.spring.cloud.extend.listener"),
        @ComponentScan("com.zenghm.spring.cloud.extend.runner"),
        @ComponentScan("com.zenghm.spring.cloud.extend.tool")
})
public class ApplicationConfig {

}
