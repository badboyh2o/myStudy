package com.badboyh2o.jdk.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    public static int getAgeByBirth(Date birthday){
        
        Calendar cal = Calendar.getInstance();
        Calendar bir = Calendar.getInstance();
        bir.setTime(birthday);
        
        if(cal.before(birthday)){
            throw new IllegalArgumentException("The birthday is before Now,It's unbelievable");
        }
        
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayNow = cal.get(Calendar.DAY_OF_MONTH);
        
        int yearBirth = bir.get(Calendar.YEAR);
        int monthBirth = bir.get(Calendar.MONTH);
        int dayBirth = bir.get(Calendar.DAY_OF_MONTH);
        
        int age = yearNow - yearBirth;
        if(monthNow < monthBirth || (monthNow == monthBirth && dayNow < dayBirth)){
            age--;
        }
        return age;
    }
    
    
    /*main方法测试*/
    public static void main(String[] args){
        SimpleDateFormat sft = new SimpleDateFormat("yyyyMMdd");
        String sftBirth = "19960104";
        Date date = null;
        try{
            date = sft.parse(sftBirth);
        }catch(Exception e){
            e.printStackTrace();
        }
        int age = CalendarTest.getAgeByBirth(date);
        System.out.print("年龄=" + age + "岁");
    }
}
