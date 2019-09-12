package com.hqxu.testDate;

import java.util.Date;

public class T1 {

    
    public static void main(String[] args) {
        
        
        Date d = new Date();
        System.out.println(d);
        
        long ten = 20*3600*24*1000L;
        Date tenDay = new Date(d.getTime()+ten);
        System.out.println(tenDay);
        
        
    }
    
    
}
