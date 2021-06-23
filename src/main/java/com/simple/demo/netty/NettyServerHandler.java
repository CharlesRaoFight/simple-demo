package com.simple.demo.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @Title:com.simple.demo.netty.NettyHandler
 * @Auther: Charles Rao
 * @Date: 2020/05/17/11:24
 * @Description:
 */
public class NettyServerHandler extends SimpleChannelInboundHandler {

    //接收数据
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object o) throws Exception {
        // 接受我们的数据
        ByteBuf byteBuf = (ByteBuf) o;
        String receiveText = byteBuf.toString(CharsetUtil.UTF_8);
        System.out.println("服务端接收消息:"+receiveText);
        // 响应内容:
        ctx.writeAndFlush(Unpooled.copiedBuffer("hi,i'm a  netty server\n", CharsetUtil.UTF_8));
    }
}
