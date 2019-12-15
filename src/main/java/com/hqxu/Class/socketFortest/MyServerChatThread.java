package com.hqxu.Class.socketFortest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
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
		
		try(InputStream in = socket.getInputStream();
			)
		{
			byte[] read = new byte[4];
			in.read(read);
			System.out.println(new String(read, "GBK"));
			
	         byte[] read1 = new byte[4];
            in.read(read1);
            System.out.println(new String(read1, "GBK"));
            
            
           byte[] read2 = new byte[2];
           in.read(read2);
           System.out.println(new String(read2, "GBK"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
