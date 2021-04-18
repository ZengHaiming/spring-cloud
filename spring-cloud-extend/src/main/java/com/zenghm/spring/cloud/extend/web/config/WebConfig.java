package com.zenghm.spring.cloud.extend.web.config;

import com.zenghm.spring.cloud.extend.web.converter.DateConverter;
import com.zenghm.spring.cloud.extend.web.filter.AuthFilter;
import com.zenghm.spring.cloud.extend.web.handler.CustomHandlerMethodArgumentResolver;
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
    /**
     * 添加过滤器 ，并且设置过滤的url 及顺序
     * @return
     */
    @Bean
    public FilterRegistrationBean reqResFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        AuthFilter authFilter = new AuthFilter();
        filterRegistrationBean.setFilter(authFilter);
        filterRegistrationBean.addUrlPatterns("/*");//配置过滤规则
        filterRegistrationBean.setOrder(1); //设置执行顺序
        return filterRegistrationBean;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
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
        argumentResolvers.add(new CustomHandlerMethodArgumentResolver());
    }
}
