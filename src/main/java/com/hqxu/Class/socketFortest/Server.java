package com.hqxu.Class.socketFortest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {
    public static void main(String[] args) throws IOException {
        
        // 服务端socket
        ServerSocket server =new ServerSocket(20000);
        
        while(true){
            // 一直监听客户端连接。 阻塞，直到有客户端连接
            Socket socket=server.accept(); //对应客户端的socket
            // 一个连接启动一个线程
            new Thread(new MyServerChatThread(socket)).start();
            
        }
    }
}
