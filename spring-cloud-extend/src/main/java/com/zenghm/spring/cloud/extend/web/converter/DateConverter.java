package com.zenghm.spring.cloud.extend.web.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Airlen
 * @date 2021/4/18
 * @description xxx
 */
public class DateConverter implements Converter<String, Date> {
    private Logger logger = LoggerFactory.getLogger(DateConverter.class);
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public Date convert(String s) {
        if ("".equals(s) || s == null) {
            return null;
        }
        try {
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            logger.error(e.getMessage(),e);
        }
        return null;
    }
}
