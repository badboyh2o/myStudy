package com.hqxu.Class.Calendar;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 1.Calendar 日历类
 *  抽象类
 *      java.util.Calender
 *          java.util.GregorianCalendar
 *          java.util.JapaneseImperialCalendar
 *      
 *  构造方法私有
 *  
 * 2.TimeZone 时区
 *  不同时区,时间不同
 * 
 * 3.Locale 地域
 *  不同地域，时间的表示不同
 *  
 */
public class CalendarClass {

    
    public static void main(String[] args) {
        
        // 1.获取Calendar实例
        Calendar c1 = Calendar.getInstance();
        System.out.println(c1);
        System.out.println(c1.getTimeZone()); // TimeZone
        
        // Calendar Date 转换
        Date d1 = c1.getTime();
        System.out.println(d1);    // Wed Sep 11 12:41:16 CST 2019
        
        c1.setTime(new Date());
        System.out.println(c1);
        
        // 默认时区
        TimeZone tz = TimeZone.getDefault();
        System.out.println(tz); // sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=19,lastRule=null]
        
        // 默认区域
        Locale locale = Locale.getDefault();
        System.out.println(locale); // zh_CN
        
        
        // 2.测试区域
        // 创建 Locale
        Locale localeCN = Locale.SIMPLIFIED_CHINESE;
        Locale localeUS = new Locale("en", "US");
        // 通过 DateFormat 格式化 日期
        String cn = DateFormat.getDateInstance(DateFormat.LONG, localeCN).format(d1);
        String us = DateFormat.getDateInstance(DateFormat.LONG, localeUS).format(d1);
        System.out.println(cn); //2019年9月11日
        System.out.println(us); //September 11, 2019
        //System.out.printf("cn=%s\nus=%s\n", cn, us);
        
        
        // 3.测试时区
        // 获取默认的DateFormat，用于格式化Date
        DateFormat df = DateFormat.getInstance();
        // 使用默认时区
        String defaultds = df.format(d1);
        System.out.println(tz.getID()+" :"+defaultds);
        
        
        // 设置时区
        df.setTimeZone(TimeZone.getTimeZone("GMT-11:00"));
        String newds = df.format(d1);
        System.out.println(tz.getID()+" :"+newds);
        
        
        
        
        // 4.国际化
        Object[] params = {"Jack", new GregorianCalendar().getTime(), 8888};
        
        String pattern1 = "{0}，你好！你于  {1} 消费  {2} 元。";
        String msg1 = MessageFormat.format(pattern1, params);
        System.out.println(msg1);
        
        String pattern2 = "At {1,time,short} On {1,date,long}，{0} paid {2,number, currency}.";
        MessageFormat mf = new MessageFormat(pattern2, Locale.US);
        String msg2 = mf.format(params);
        System.out.println(msg2);
        
        
        
        
    }
    
    
}
