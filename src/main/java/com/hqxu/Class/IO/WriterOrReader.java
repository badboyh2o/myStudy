package com.hqxu.Class.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.springframework.core.io.ClassPathResource;


/**
 * 
 * 1.springboot 打包, 读取classPath下的资源
 *   ClassPathResource fileResource = new ClassPathResource("io/reader.txt");
 * 
 * 
 *
 */

public class WriterOrReader {

    
    // 测试 Reader Writer
    public static void main(String[] args) {
        
        // 1.测试 BufferedReader
        testBufferedReader();
        
        // 2.测试 printWriter
        testPrintWriter();
        
    }
    
    
    
    /**
     * 1.测试 BufferedReader
     */
    public static void testBufferedReader() {
        
        // springboot 打包, 应该采用这种方式读取classPath下的资源
        ClassPathResource fileResource = new ClassPathResource("io/reader.txt");
        
        
        // 测试 Resource 的 URI URL
        try {
            System.out.println(fileResource.getURI());
            System.out.println(fileResource.getURL());
        } catch (IOException e1) {
        }
        
        // 不能输出到resources, 这里测试
        File out = new File("src/main/resources/io/reader.copy.txt");
        
        BufferedReader br = null;
        BufferedWriter bw = null;
        
        try {
            // 转换流 InputStreamReader
            br = new BufferedReader(new InputStreamReader(fileResource.getInputStream(),"utf-8"));
            bw = new BufferedWriter(new FileWriter(out));
            String s = null;
            while((s=br.readLine()) != null) {
                bw.write(s);
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("io exception");
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
            if(bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                }
            }
        }
    }
    
    
    /**
     * 2.测试 PrintWriter
     */
    public static void testPrintWriter() {
        
        PrintWriter pw = null;
        // 不能输出到resources, 这里测试
        try {
            pw = new PrintWriter("src/main/resources/io/printwriter.txt");
            
            pw.write("hello world");
            
        } catch (FileNotFoundException e) {
            System.out.println("fiel not found");
        } finally {
            
            if(pw != null) {
                pw.close();
            }
        }
        
        
        
    }
    
}
