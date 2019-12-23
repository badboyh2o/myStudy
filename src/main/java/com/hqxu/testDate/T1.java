package com.hqxu.testDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class T1 {

    
    public static void main(String[] args) {
        
        
        
        
        GjjAccountInfo g1 = new GjjAccountInfo();
        GjjAccountInfo g2 = new GjjAccountInfo();
        g1.setTrDate("2013-09-10 15:45:23");
        g1.setTrDate("2018-09-10 15:45:23");
        g2.setTrDate("2017-04-03 12:45:12");

        List<GjjAccountInfo> list = new ArrayList<GjjAccountInfo>();
        list.add(g1);
        list.add(g2);
        Collections.sort(list,new Comparator<GjjAccountInfo>(){
            @Override public int compare(GjjAccountInfo o1,GjjAccountInfo o2){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    return (int)(sdf.parse(o1.getTrDate()).getTime() - (sdf.parse(o2.getTrDate())).getTime());
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


