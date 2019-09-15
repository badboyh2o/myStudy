package com.hqxu.Class.socketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *  读取客户端消息
 *  转发给其它客户端 
 *
 */
public class ServerThread implements Runnable{

    // 客户端socket
    private Socket socket;
    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    // 处理当前socket
    @Override
    public void run() {
        BufferedReader br =null;
        PrintWriter pw = null;
        
        // 准备读socket
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            String m = null;
            //阻塞，知道读取到一行
            while((m=br.readLine())!=null) {
                for(Socket s : Server.clientSockets) {
                    if(s != socket) {
                        // 准备写socket，发消息
                        pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
                        pw.println(m);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            pw.close();
        }
    }

}
