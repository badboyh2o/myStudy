package com.hqxu.Class.socketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 接收服务端的消息，输出到控制台
 *
 */
public class ClientThread implements Runnable{

    // 当前socket
    private Socket socket;
    public ClientThread(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        
        BufferedReader br = null;
        PrintWriter pw = null;
        
        
        try {
            // 读 socket
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 写到控制台(自动flush)
            pw = new PrintWriter(new OutputStreamWriter(System.out), true);
            
            String m = null;
            while((m=br.readLine())!=null) {
                pw.println("other: " + m);
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
            if(pw != null) {
                pw.close();
            }
        }
    }
    
}
