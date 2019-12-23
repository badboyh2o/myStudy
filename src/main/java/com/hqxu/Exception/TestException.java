package com.hqxu.Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestException extends Exception{
    
    private static final long serialVersionUID = 1L;
    
    private String message = "hello";
    
    // 重写了Throwable的方法
    public String getMessage() {
        return this.message;
    }
    private void setMessage(String msg) {
        this.message = msg;
    }
    

    public TestException() {
    }
    
    public TestException(String msg) {
        //super(msg);
        super(msg);
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        


        System.gc();
        
        
        TestException e = new TestException();
        e.setMessage("ex");
        
        // 序列化
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("g:/test/1.txt"));
        oo.writeObject(e);
        oo.close();
        
        // 反序列化
        ObjectInputStream oi = new ObjectInputStream(new FileInputStream("g:/test/1.txt"));
        TestException ex1 = (TestException)oi.readObject();
        System.out.println(ex1.getMessage());
        
    }
    
    
    public void test() throws TestException {
        throw new TestException("this is defined exception!");
    }
    

}
