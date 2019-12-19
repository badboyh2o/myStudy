package com.hqxu.Class.socket.keepalive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 开启一个线程，与服务端建立长连接
 */
public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {
        
        // 与服务端简历连接
        Socket socket = new Socket("127.0.0.1", 20000);
        
        // 1.启动接受消息的线程
        new Thread(new ClientThread(socket)).start();
        
        
        /*
        // 2.主线程发送消息
        // 从控制台输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 写到socket
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true); // 自动flush
        String m = null;
        // 一致监听控制台输入
        while((m=br.readLine()) != null) {
            pw.println(m);
        }
        */
        
        
    }
    
}
