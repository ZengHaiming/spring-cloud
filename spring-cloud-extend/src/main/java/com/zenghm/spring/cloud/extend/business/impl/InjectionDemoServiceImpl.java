package com.zenghm.spring.cloud.extend.business.impl;

import com.zenghm.spring.cloud.extend.business.InjectionDemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Airlen
 * @date 2021/4/18
 * @description xxx
 */
@Service
public class InjectionDemoServiceImpl implements InjectionDemoService {
    private Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);
    @Override
    public void doBusiness() {
        logger.debug("类 InjectionDemoServiceImpl 执行业务代码");
    }
}
