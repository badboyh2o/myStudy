package com.hqxu.Class.Date;

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


/**
 * java.util.Date
 *      java.sql.Date   2018-06-30
 *      java.sql.Time   21:20:33
 *      java.sql.Timestatmp 2018-06-30 21:20:33
 *      
 *      
 * 简单日期转换 (Date String)
 *   SimpleDateFormat     
 */
public class DateClass {


    public static void main(String[] args) throws ParseException {
        
        // java.util.Date
        Date d1 = new Date();
        System.out.println(d1); //Wed Sep 11 11:57:19 CST 2019
        
        // Date 转换
        Date d2 = new java.sql.Date(d1.getTime());
        System.out.println(d2); //2019-09-11
        
        // 生成日期格式 DateFormat
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        
        // 格式化时间 .format()
        String ds1 = sdf1.format(d1); // 2019-09-11 12:04:52 星期三
        System.out.println(ds1);
        
        // 将日期字符串转为日期 .parse()
        Date d3 = sdf1.parse("2019-09-19 18:04:52 星期一");
        System.out.println(d3); // Thu Sep 19 18:04:52 CST 2019
        

        
    }
}
