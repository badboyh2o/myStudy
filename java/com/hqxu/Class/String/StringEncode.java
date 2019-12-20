package com.hqxu.Class.String;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class StringEncode {

    
    public static void main(String[] args) throws IOException {
       System.out.println(testEncode()); 
    }
    
    public static String testEncode() throws IOException {
       
        String src = "123hello";
        String src1 = "";
        
        try {
            byte[] a = src.getBytes("utf-8");
            
            
            
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            bo.write(a, 3, src.getBytes("utf-8").length-3);
            bo.flush();
            System.out.println(bo.toString());
            
            byte[] c = new byte[a.length-3];
            ByteArrayInputStream bi = new ByteArrayInputStream(a);
            bi.read(c, 3, a.length-3);
            System.out.println(new String(c));
            
            
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        
        try {
            src1 = new String(src.getBytes(), "gbk");
            System.out.println(src.getBytes("utf-8").length);
            System.out.println(src.getBytes("gbk").length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        
        return src1;
    }
}
