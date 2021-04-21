package com.zenghm.spring.cloud.extend.business.impl;

import com.zenghm.spring.cloud.extend.business.InjectionDemoService;
import com.zenghm.spring.cloud.extend.constent.ENSex;
import com.zenghm.spring.cloud.extend.dto.RequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Airlen
 * @date 2021/4/18
 * @description xxx
 */
@Service
public class InjectionDemoServiceImpl implements InjectionDemoService {
    private Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);
    @Override
    public RequestDto doBusiness() {
        logger.info("类 InjectionDemoServiceImpl 执行业务代码");
        RequestDto requestDto = new RequestDto();
        requestDto.setAge(24);
        requestDto.setBirthday(new Date());
        requestDto.setIsworke(Boolean.TRUE);
        requestDto.setName("张三");
        requestDto.setSex(ENSex.BOY);
        return requestDto;
    }
}
