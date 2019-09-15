package com.hqxu.Class.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 接收服务端转发过来的群聊信息，然后输出到控制台
 *
 */
public class MyClientChatThread implements Runnable{

    // 当前客户端socket
	private Socket socket;
	public MyClientChatThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		
		try(BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				)
			{
				String message=null;
				
				// 线程阻塞，直到收到一行消息
				while((message=br.readLine())!=null)
				{			
					//转发给各个客户端 
					System.out.println("别人说： "+message);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
