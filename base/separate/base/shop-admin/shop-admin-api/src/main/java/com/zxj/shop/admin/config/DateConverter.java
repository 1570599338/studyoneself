package com.zxj.shop.admin.config;

import cn.hutool.core.date.DateUtil;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        if (source != null && source.length() > 0) {
            return DateUtil.parse(source, "yyyy-MM-dd");
        }
        return null;
    }
}