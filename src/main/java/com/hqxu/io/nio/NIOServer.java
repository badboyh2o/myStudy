package com.hqxu.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;


/**
 * 服务端
 *  监听客户端连接
 *  广播客户端消息
 *
 */
public class NIOServer {
    
    
    public static void main(String[] args) throws IOException {
        NIOServer nioServer = new NIOServer();
        nioServer.start();
    }
    


    /**
     * 启动Server
     * @throws IOException
     */
    public void start() throws IOException {
        // 1.创建selector
        Selector selector = Selector.open();
        
        // 2.通过ServerSocketChannel创建Channel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        
        // 3.为channel通道绑定监听端口
        serverSocketChannel.bind(new InetSocketAddress(8888));
        
        // 4.设置channel为非阻塞模式
        serverSocketChannel.configureBlocking(false);
        
        // 5.将channel注册到selector上，监听连接事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("server started!");
        
        // 6.死循环等待新的连接
        while(true) {
            // !! 获取可用的channel数量
            int readyChannels = selector.select(); //阻塞等待事件发生
            // !!
            if(readyChannels == 0) continue;
            
            // 获取可用channel的集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            
            // !!遍历事件
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while(iterator.hasNext()) {
                SelectionKey selectionKey = (SelectionKey)iterator.next();
                
                // !! 移除当前Set中的selectionKey (处理完需要移除)
                iterator.remove();
                
                // 7.根据就绪状态编写业务逻辑
                // 如果是接入事件
                if(selectionKey.isAcceptable()) {
                    acceptHandler(serverSocketChannel, selector);
                }
                
                if(selectionKey.isReadable()) {
                    readHandler(selectionKey, selector);
                }
                
                
            }
            
        }
    }
    
    
    /**
     * 接入事件处理器
     * @throws IOException 
     */
    private void acceptHandler(ServerSocketChannel serverSocketChannel, Selector selector) throws IOException {
        // 创建 socketChannel
        SocketChannel socketChannel = serverSocketChannel.accept();
        
        // 将socketChannel设置为非阻塞工作模式
        socketChannel.configureBlocking(false);
        
        // !! 将channel注册到selector上，监听 可读事件
        socketChannel.register(selector, SelectionKey.OP_READ);
        
        // 回复客户端提示信息
        socketChannel.write(Charset.forName("UTF-8").encode("你已加入群聊"));
        
    }
    
    
    /**
     * 可读事件处理器
     * @throws IOException 
     */
    private void readHandler(SelectionKey selectionKey, Selector selector) throws IOException {
        // 从selectionKey中获取已经就绪的channel
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        
        // 创建Buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        
        // 循环读取客户请求信息
        String request = "";
        while(socketChannel.read(byteBuffer) > 0) {
            // !!切换Buffer为读模式
            byteBuffer.flip();
            
            // 读取Buffer中的内容
            request += Charset.forName("UTF-8").decode(byteBuffer);
        }
        
        
        // !! 将channel再次注册到selector上,监听它的可读事件
        socketChannel.register(selector, SelectionKey.OP_READ);
        
        // 将信息广播给其他客户端
        if(request.length() > 0) {
            System.out.println(request);
            broadCast(selector, socketChannel, request);
        }
        
    }
    
    
    /**
     * 广播消息
     * @param selector
     */
    private void broadCast(Selector selector, SocketChannel sourceChannel, String request) {
        
        // 获取所有已接入的客户端channel
        Set<SelectionKey> selectionKeySet = selector.keys();
        
        // 遍历
        selectionKeySet.forEach(selectionKey -> {
            Channel targetChannel = selectionKey.channel();
            // 不需要转发给当前客户端
            if(targetChannel instanceof SocketChannel && targetChannel != sourceChannel) {
                try {
                    ((SocketChannel)targetChannel).write(Charset.forName("UTF-8").encode(request));
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }
        });
    }
    
}
