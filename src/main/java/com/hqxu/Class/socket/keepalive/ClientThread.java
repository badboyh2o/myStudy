package com.hqxu.Class.socket.keepalive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 接收服务端的消息，输出到控制台
 *      数据包：6位长度 + 数据
 */
public class ClientThread implements Runnable{

    // 当前socket
    private Socket socket;
    public ClientThread(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        
        InputStream br = null;
        PrintWriter pw = null;
        
        
        try {
            // 读 socket
            br = socket.getInputStream();
            // 写到控制台(自动flush)
            pw = new PrintWriter(new OutputStreamWriter(System.out), true);
            
            
            // 接收响应，读取一定长度的报文
            while(true) {
                byte[] i = new byte[6];
                br.read(i);
                String is = new String(i);
                byte[] i2 = new byte[Integer.parseInt(is)];
                br.read(i2);
                pw.println("server: " + new String(i2));
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(pw != null) {
                pw.close();
            }
        }
    }
    
}
