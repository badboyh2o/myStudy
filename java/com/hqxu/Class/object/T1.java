package com.hqxu.Class.object;

public class T1 {

    public static void main(String[] args)
    {

        int[][] x = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        for(int[] m : x) 
        {
            for(int k : m)
            {
                System.out.println(k);
            }
        }
        System.out.println(x.getClass().getName());
       
        
        A a = new A();
        
        System.out.println(a);
        
    }

}