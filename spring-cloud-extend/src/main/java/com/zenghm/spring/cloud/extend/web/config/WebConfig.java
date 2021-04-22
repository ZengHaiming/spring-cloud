package com.zenghm.spring.cloud.extend.web.config;

import com.zenghm.spring.cloud.extend.web.converter.DateConverter;
import com.zenghm.spring.cloud.extend.web.filter.AuthFilter;
import com.zenghm.spring.cloud.extend.web.handler.CustomHandlerMethodArgumentResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author Airlen
 * @date 2021/4/18
 * @description xxx
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    private static Logger logger = LoggerFactory.getLogger(WebConfig.class);
    /**
     * 添加过滤器 ，并且设置过滤的url 及顺序
     * @return
     */
    @Bean
    public FilterRegistrationBean authFilter() {
        logger.info("添加自定义过滤器");
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        AuthFilter authFilter = new AuthFilter();
        filterRegistrationBean.setFilter(authFilter);
        filterRegistrationBean.addUrlPatterns("/*");//配置过滤规则
        filterRegistrationBean.setOrder(1); //设置执行顺序
        return filterRegistrationBean;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        logger.info("添加自定义类型转换器");
        registry.addConverter(new DateConverter());
    }

    /**
     * {@inheritDoc}
     * <p>This implementation is empty.
     *
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        // 添加自定义参数处理器
        logger.info("添加自定义参数解析器");
        argumentResolvers.add(new CustomHandlerMethodArgumentResolver());
    }
}
