package com.simple.demo.tcp.client;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class SocketBioClient {

    public static void main(String[] args) {
        try{
            Socket socket = new Socket();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getLocalHost(),8181);
            socket.connect(inetSocketAddress);
            socket.getOutputStream().write("在吗？".getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
