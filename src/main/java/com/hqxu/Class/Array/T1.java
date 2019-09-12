package com.hqxu.Class.Array;

public class T1 {
    public static void main(String[] args) {
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
        



        
    }
}
