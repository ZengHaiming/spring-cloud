package com.zenghm.spring.cloud.extend.web;

import com.zenghm.spring.cloud.extend.web.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author Airlen
 * @date 2021/4/11
 * @description xxx
 */
@SpringBootApplication
//@Import(ApplicationConfig.class)
public class SpringCloudExtendApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudExtendApplication.class,args);
    }
}
