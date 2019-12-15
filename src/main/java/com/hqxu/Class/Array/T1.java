package com.hqxu.Class.Array;

import java.util.Arrays;

public class T1 {
    public static void main(String[] args) {
        reverseInt();

        reverseString();
        
    }

    /**
     * 数组 逆序输出
     */
    private static void reverseInt() {
        int[] ints = new int[] {1,2,3,4,5,6,7,8,9,10};
        
        int center = ints.length/2;
        
        int head = 0;
        int tail = ints.length-1;
        
        int temp = 0;
        for(int x =0; x < center; x++) {
            temp = ints[head];
            ints[head] = ints[tail];
            ints[tail] = temp;
            
            head++;
            tail--;
        }
        
        System.out.println(Arrays.toString(ints));
    }
    
    
    public static void reverseString() {
        String[] Strings = new String[] {"a","b","c","d"};
        
        for (int i = 0;i < Strings.length / 2 ; i++) {
            String temp = Strings[i];
            Strings[i] = Strings[Strings.length-1-i];
            Strings[Strings.length-1-i] = temp;
        }
        System.out.println(Arrays.toString(Strings));
    }
    
    
}
