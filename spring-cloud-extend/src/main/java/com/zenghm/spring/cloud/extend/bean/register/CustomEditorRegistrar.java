package com.zenghm.spring.cloud.extend.bean.register;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.stereotype.Component;

/**
 * @author Airlen
 * @date 2021/4/18
 * @description bean 属性编辑
 */
@Component
public class CustomEditorRegistrar implements PropertyEditorRegistrar {
    private Logger logger = LoggerFactory.getLogger(CustomEditorRegistrar.class);
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        logger.info("属性编辑");
    }
}
