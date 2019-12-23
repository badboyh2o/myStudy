package com.hqxu.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * 客户端
 *  向服务端发送消息
 *  启动新的线程接收服务端消息
 *
 */
public class NIOClient {

    public static void main(String[] args) throws IOException {
        NIOClient nioClient = new NIOClient();
        nioClient.start();
    }
    
    /**
     * 启动client
     * @throws IOException
     */
    public void start() throws IOException {
        // 连接服务端
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));
        System.out.println("clinet start!");
        
        // 接收服务端响应
        // !!新开一个线程
        Selector selector = Selector.open();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        new Thread(new NIOClientHandler(selector)).start();
        
        
        // 向服务端发送数据
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String request = scanner.nextLine();
            if(request != null && request.length() > 0) {
                socketChannel.write(Charset.forName("UTF-8").encode(request));
            }
        }
        
    }
}
