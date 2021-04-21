package com.zenghm.spring.cloud.extend.web.filter;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author Airlen
 * @date 2021/4/21
 * @description xxx
 */
public class SpringBootApplicationExcludeFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        return metadataReader.getAnnotationMetadata().isAnnotated(SpringBootConfiguration.class.getName())
                || metadataReader.getAnnotationMetadata().isAnnotated(SpringBootApplication.class.getName());
    }
}