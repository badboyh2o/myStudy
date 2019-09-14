package com.hqxu.Class.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *  模拟 群聊
 *  需求：一个客户发送信息，群内所有人都能收到信息
 *  
 */
public class MyServer {
	
	//存放所有客户端套接字的集合
	//该集合会被多个线程并发访问，为确保数据安全，所以同步，上锁
	public static List<Socket> clientScokets=Collections.synchronizedList(new ArrayList<>());

	
	public static void main(String[] args) throws IOException {
		//在服务端实例化一个ServerSocket对象，指定了端口号
		ServerSocket server=new ServerSocket(20000);
		
		//让该套接字调用accept方法，该方法会让套接字一直等待，一直阻塞，直到有客户端套接字请求该端口阻塞解除
		
		
		while(true)
		{
			//要接收多个客户端的连接请求，所以该行代码应该放入while循环中
			//该方法会返回一个新的Socket，与客户端的socket对应，就是是同一个socket的意思
			Socket socket=server.accept();
			clientScokets.add(socket);
			// 开1个线程，能够跟每个客户端聊天，来一个客户，开一个线程
			new Thread(new MyServer_chat_thread(socket)).start();
		}
		
	}

}
