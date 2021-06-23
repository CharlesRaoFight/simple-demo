package com.simple.demo.tcp.server;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketBioServer {
    static byte[] bytes =new byte[1024];
    public static void main(String[] args) {

        try{
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(8181));
            System.out.println("正在等待接收数据...");
            //多线程
            ExecutorService executorService = Executors.newCachedThreadPool();
            while (true){
                Socket socket = serverSocket.accept();
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            int read = socket.getInputStream().read(bytes);
                            String result = new String(bytes);
                            System.out.println("服务器端获取数据："+result);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
