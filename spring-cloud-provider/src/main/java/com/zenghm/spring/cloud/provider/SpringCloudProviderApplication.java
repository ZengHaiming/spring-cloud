package com.zenghm.spring.cloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Create date:20/7/26.
 * Created by: zhm.
 * Class name:SpringCloudProviderApplication.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProviderApplication.class,args);
    }
}
