package com.hqxu.Class.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 处理客户端socket，然后将消息转发给各个客户端
 *
 */
public class MyServerChatThread implements Runnable{
	
    // 客户端socket
	private Socket socket;
	public MyServerChatThread(Socket socket) {
		this.socket = socket;
	}


	@Override
	public void run() {
		
		try(BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			)
		{
			String message=null;
			// readLine() 如果没有一行数据，线程阻塞
			while((message=br.readLine())!=null)
			{			
				//转发给其他各个客户端 
				for(Socket s:MyServer.clientSockets)
				{
					if(s==this.socket)
					{
						continue;
					}
					//往socket写入数据
					PrintWriter pw=new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
					pw.println(message);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
