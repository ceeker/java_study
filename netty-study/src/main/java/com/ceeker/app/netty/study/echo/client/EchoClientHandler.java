package com.ceeker.app.netty.study.echo.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * 客户的处理器
 * <p>
 * 连接服务器
 * 发送信息
 * 发送的每个信息，等待和接收从服务器返回的同样的信息
 * 关闭连接
 * Created by vectorzhang on 2017/5/7.
 */
@Sharable                                //1
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    /**
     * 连接建立后被调用，然后将消息发送到服务器
     *
     * @param ctx
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        String sendMsg = "hello server";
        ctx.writeAndFlush(Unpooled.copiedBuffer(sendMsg, CharsetUtil.UTF_8));
        System.out.println("client send:" + sendMsg);
    }

    /**
     * 接收到数据时被调用，然后读取接受到的消息
     *
     * @param ctx
     * @param in
     */
    @Override
    public void channelRead0(ChannelHandlerContext ctx, ByteBuf in) {
        System.out.println("Client received: " + in.toString(CharsetUtil.UTF_8));    //3
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {                    //4
        cause.printStackTrace();
        ctx.close();
    }
}