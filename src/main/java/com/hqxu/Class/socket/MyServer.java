package com.hqxu.Class.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1.监听socket; 一个客户端socket对应启动一个线程进行处理: 
 *      接收客户端的消息,并转发给其他客户端
 *
 */
public class MyServer {

	// 保存所有客户端连接；  并发访问，同步
	public static List<Socket> clientSockets=Collections.synchronizedList(new ArrayList<>());
	
	public static void main(String[] args) throws IOException {
	    
		ServerSocket server =new ServerSocket(20000);
		
		// 一直监听客户端连接
		while(true){
		    
			// 阻塞，直到有客户端连接
			Socket socket=server.accept(); //对应客户端的socket
			clientSockets.add(socket);
			// 一个连接启动一个线程
			new Thread(new MyServerChatThread(socket)).start();
			
		}
	}
}
