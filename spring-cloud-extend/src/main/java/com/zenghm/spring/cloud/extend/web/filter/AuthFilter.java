package com.zenghm.spring.cloud.extend.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Airlen
 * @date 2021/4/18
 * @description 过滤器
 * 需要添加 在启动类上加一个注解 @ServletComponentScan 就可以了，然后启动springboot 访问你的接口就会看到打印过滤器里的内容了
 */
//@Order(1)  此注解在 WebFilter 注解中无效 ，需要根据过滤器的名称默认排序
//@WebFilter(urlPatterns = "/*",filterName = "authFilter") 如果使用注解的方式添加过滤器则需要 添加 启动类上加一个注解 @ServletComponentScan
public class AuthFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(AuthFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        logger.debug("执行过滤器:AuthFilter");
    }

    @Override
    public void destroy() {

    }
}
