package com.hqxu.Class.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * 启动两个线程
 *  1.接收服务端转发其他客户端的消息
 *  2.接收控制台输入的消息，发送到服务端
 * 
 *
 */
public class MyClient {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
	    
	    // 连接到服务端
		Socket socket=new Socket("127.0.0.1", 20000);
		
		// 1.收消息  
		new Thread(new MyClientChatThread(socket)).start();
		
		
		// 2.发消息(接收控制台输入的数据)
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String message=null;
		PrintWriter pw=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
		// readLine() 会导致线程阻塞，直到有一行消息输入
		while((message=br.readLine())!=null){
			// 写socket
			pw.println(message);
		}
		// 不需要关闭流
	}
	
}
