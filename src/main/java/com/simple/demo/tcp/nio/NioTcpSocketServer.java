package com.simple.demo.tcp.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @Title:simpledemo
 * @Auther: Charles Rao
 * @Date: 2020/05/14/23:56
 * @Description:
 */
public class NioTcpSocketServer {

    private static ByteBuffer byteBuffer = ByteBuffer.allocate(512);
    private static List<SocketChannel> socketChannelList = new ArrayList<>();

    public static void main(String[] args) {
        try{
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8181));
            serverSocketChannel.configureBlocking(false);
            while(true){
                SocketChannel socketChannel = serverSocketChannel.accept();
                if(socketChannel != null){
                    socketChannelList.add(socketChannel);
                }
                for(SocketChannel scl : socketChannelList){
                    int read = scl.read(byteBuffer);
                    if(read>0){
                        byteBuffer.flip();
                        Charset charset = Charset.forName("utf-8");
                        String receiveText = charset.newDecoder().decode(byteBuffer.asReadOnlyBuffer()).toString();
                        System.out.println("接收到的信息:"+receiveText);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("结束程序...");

    }


}
