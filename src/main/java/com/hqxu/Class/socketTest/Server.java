package com.hqxu.Class.socketTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ch.qos.logback.core.net.server.Client;

/**
 * 1.启动新的线程处理socket: 读取客户端的消息，转发给其他客户端
 *
 */

public class Server {
    
    // 临界资源，同步锁
    static List<Socket> clientSockets = Collections.synchronizedList(new ArrayList<Socket>());
    
    
    public static void main(String[] args) throws IOException {
    
        // 服务端socket
        ServerSocket serverSocket = new ServerSocket(30000);
        
        // 一致监听
        while(true) {
            Socket socket = serverSocket.accept(); // 阻塞
            // 将监听到的客户端 socket 加入 集合
            clientSockets.add(socket);
            // 并启动一个线程处理当前socket
            new Thread(new ServerThread(socket)).start();
        }
        
    }
    

}
