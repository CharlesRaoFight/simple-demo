package com.simple.demo.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.nio.ByteBuffer;

/**
 * @Title:com.simple.demo.netty.NettyClientHandler
 * @Auther: Charles Rao
 * @Date: 2020/05/17/16:29
 * @Description:
 */
public class NettyClientHandler extends SimpleChannelInboundHandler {
    //读取数据
    @Override
    protected void channelRead0(ChannelHandlerContext context, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf)msg;
        String msgStr = byteBuf.toString(CharsetUtil.UTF_8);
        System.out.println("客户端收到的消息:"+msgStr);
    }

    //活跃的通道
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for(int i=0;i<10;i++){
            System.out.println("客户端开始发送消息");
            ctx.writeAndFlush(Unpooled.copiedBuffer("Hello,I'm netty client!\n" ,CharsetUtil.UTF_8));
        }
    }
}
