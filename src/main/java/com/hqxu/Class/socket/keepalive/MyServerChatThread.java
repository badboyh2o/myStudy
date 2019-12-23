package com.hqxu.Class.socket.keepalive;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 保持长连接
 *  接受到请求报文后（模拟等待1s）,相应一个数据包（6位长度 + 数据）
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
	    InputStream in = null;
	    try {
            in = socket.getInputStream();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
	    
        OutputStream out = null;
        try {
            out = socket.getOutputStream();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
	    

	    while(true) {
	        //接受到请求 in, 读取一段长度的报文
	        try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
	        
	        
	        //处理请求，响应 out
	        
    		try {
    
    			out.write("000002aa".getBytes());
    			out.flush();
    			
    			
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
	    }
		
	}
	
}
