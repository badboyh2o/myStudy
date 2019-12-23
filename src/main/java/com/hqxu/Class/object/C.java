package com.hqxu.Class.object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class VO {
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VO(String name) {
        super();
        this.name = name;
    }

    public VO() {
        super();
    }

    @Override
    public String toString() {
        return "VO [name=" + name + "]";
    }
    
}

public class C {

    public static void main(String[] args) {
        
        List<VO> r = new ArrayList<>();
        
        VO[] arr = new VO[] {new VO("xiaoming"),new VO("hqxu")};
        List<VO> list = new ArrayList<>(Arrays.asList(arr));

        VO c = new VO();
        
        for (VO s: list) {
            
  
            c.setName(s.getName());
            System.out.println(c.toString());
            r.add(c);
            System.out.println(r.toString());
        }
        
        
        //System.out.println(r.toString());
        
        
        
        
        
        
    }
    
    
}
