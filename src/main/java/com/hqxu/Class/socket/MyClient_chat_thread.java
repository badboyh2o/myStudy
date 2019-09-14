package com.hqxu.Class.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyClient_chat_thread implements Runnable {
	
	/**
	 * 专门不停地接收服务端转发过来的群聊信息,然后输出到控制台
	 * 所以需要持有与客户端对应的socket
	 */
	
	private Socket socket;
	
	public MyClient_chat_thread(Socket socket)
	{
		this.socket=socket;
	}

	@Override
	public void run() {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));)
		{
			while(true)
			{
				String message=br.readLine();
				System.out.println("别人说："+message);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
