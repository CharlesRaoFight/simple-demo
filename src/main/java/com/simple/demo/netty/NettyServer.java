package com.simple.demo.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @Title:com.simple.demo.netty.NettyServer
 * @Auther: Charles Rao
 * @Date: 2020/05/16/16:04
 * @Description:
 */
public class NettyServer {

    public static void main(String[] args) {

        NioEventLoopGroup acceptGroup = new NioEventLoopGroup();
        NioEventLoopGroup handleGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(acceptGroup,handleGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
                socketChannel.pipeline().addLast(new StringEncoder());
                socketChannel.pipeline().addLast(new NettyServerHandler());
            }
        });
        try {
            //绑定端口号
            ChannelFuture future = serverBootstrap.bind(8080).sync();
            System.out.println("服务器端口启动:"+8383);
            //等待监听后面的请求
            future.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            acceptGroup.shutdownGracefully();
            handleGroup.shutdownGracefully();
        }


    }

}
