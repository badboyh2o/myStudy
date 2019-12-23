package com.hqxu.xml.jaxb.xstream;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.thoughtworks.xstream.converters.SingleValueConverter;

/**
 * Calendar 序列化、反序列化
 *
 */
public class SingleValueCalendarConverter implements SingleValueConverter{

    @Override
    public boolean canConvert(Class type) {
        // 允许 java.util.GregorianCalendar 类型序列化和反序列化
        return type.equals(GregorianCalendar.class);
    }

    /**
     * 序列化
     */
    @Override
    public String toString(Object obj) {
        Calendar calendar = (Calendar) obj;
        return String.valueOf(calendar.getTime().getTime());
    }

    /**
     * 反序列化
     */
    @Override
    public Object fromString(String str) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(new Date(Long.parseLong(str)));
        return calendar;
    }

}
