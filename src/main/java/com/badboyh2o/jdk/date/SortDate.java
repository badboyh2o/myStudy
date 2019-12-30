package com.badboyh2o.jdk.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class SortDate {

    
    public static void main(String[] args) {
    	String str = new String(Character.toChars(0x10ffff));
    	System.out.println(str.length());
    	System.out.println(str.codePointCount(0,str.length()));
    	System.out.println(str.codePointAt(1));
    	
    	
        GjjAccountInfo g1 = new GjjAccountInfo();
        GjjAccountInfo g2 = new GjjAccountInfo();
        GjjAccountInfo g3 = new GjjAccountInfo();
        g1.setTrDate("2013-09-10 15:45:23");
        g2.setTrDate("2018-09-10 15:45:23");
        g3.setTrDate("2017-04-03 12:45:12");

        List<GjjAccountInfo> list = new ArrayList<GjjAccountInfo>();
        list.add(g1);
        list.add(g2);
        list.add(g3);
        Collections.sort(list,new Comparator<GjjAccountInfo>(){
            @Override public int compare(GjjAccountInfo o1,GjjAccountInfo o2){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    return sdf.parse(o2.getTrDate()).compareTo(sdf.parse(o1.getTrDate()));
                } catch (ParseException e) {
                    e.printStackTrace();
                } 
                return 0;
            }
        });
        System.out.println(list.get(0));
        
    }
}

class GjjAccountInfo {
    
    private String trDate;
    private String type;
    
    public String getTrDate() {
        return trDate;
    }

    public void setTrDate(String trDate) {
        this.trDate = trDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "GjjAccountInfo [trDate=" + trDate + ", type=" + type + "]";
    }

    
    
}


