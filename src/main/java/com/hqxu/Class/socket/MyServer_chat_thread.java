package com.hqxu.Class.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class MyServer_chat_thread implements Runnable {
	
	
	/**
	 * 这个类：
	 * 专职与客户端聊天（持有与客户端相同的socket），
	 * 其实是不停的接收客户发送的信息（不停的使用InputStream的read方法），
	 * 然后再转发给各个客户端（对服务端所有套接字进行迭代访问，调用他们的输出流，把信息发给他们）
	 * 
	 */

	//持有与客户端相同的socket
	 private Socket socket;
	
	 
	 public MyServer_chat_thread(Socket socket)
	 {
		 this.socket=socket;
	 }
	
	@Override
	public void run() {
		/* 专职与客户端聊天（持有与客户端相同的socket），
		 * 其实是不停的接收客户发送的信息（不停的使用InputStream的read方法），
		 * 然后再转发给各个客户端（对服务端所有套接字进行迭代访问，调用他们的输出流，把信息发给他们）
		 * */
		try(BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));)
		{
			while(true)
			{
				//拿到客户发送的信息
				String message=br.readLine();
				
				//转发出去
				for(Socket s:MyServer.clientScokets)
				{
					if(s==this.socket)
					{
						//如果发送信息的人与s是同一个人，那么就不再转发给他了
						continue;
					}
					//转发
					PrintWriter pw=new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
					pw.println(message);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
