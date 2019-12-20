package com.hqxu.io.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class NIOClientHandler implements Runnable {

    private Selector selector;

    
    
    
    public NIOClientHandler(Selector selector) {
        super();
        this.selector = selector;
    }




    @Override
    public void run() {
        try {
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
                    // 如果是可读事件
                    if(selectionKey.isReadable()) {
                        readHandler(selectionKey, selector);
                    }
                    
                    
                }
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    
    
    
    /**
     * 可读时间处理器
     * @throws IOException 
     */
    private void readHandler(SelectionKey selectionKey, Selector selector) throws IOException {
        // 从selectionKey中获取已经就绪的channel
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        
        // 创建Buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        
        // 循环读取服务端响应
        String response = "";
        while(socketChannel.read(byteBuffer) > 0) {
            // !!切换Buffer为读模式
            byteBuffer.flip();
            
            // 读取Buffer中的内容
            response += Charset.forName("UTF-8").decode(byteBuffer);
        }
        
        
        // !! 将channel再次注册到selector上,监听它的可读事件
        socketChannel.register(selector, SelectionKey.OP_READ);
        
        if(response.length() > 0) {
            System.out.println(response);
        }
        
    }
    
    
}
