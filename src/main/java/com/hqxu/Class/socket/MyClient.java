package com.hqxu.Class.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * 模拟 群聊
 * 需求：一个客户发送信息，群内所有人都能收到信息
 *
 */
public class MyClient {

	
	public static void main(String[] args) throws UnknownHostException, IOException {
		//在客户端实例化一个Socket对象，请求服务端，需要指定ip地址和端口号
		Socket socket=new Socket("127.0.0.1", 20000);
		
		//接下来要做两件事:一个是不停的接收信息；一个是不停的发送信息。互不影响
		//一个线程收信息(另外开个线程)，
		new Thread(new MyClient_chat_thread(socket)).start();
		
		//一个线程发信息
		while(true)
		{
			//接收控制台输入信息
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String message=br.readLine();
			
			//然后调用套接字的输出流，发送给服务端
			try(PrintWriter pw=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);)
			{
				pw.write(message);
			}
		}
		
		
	}	
}
