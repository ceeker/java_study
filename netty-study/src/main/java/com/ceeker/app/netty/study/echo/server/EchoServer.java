package com.ceeker.app.netty.study.echo.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * 创建 ServerBootstrap 实例来引导服务器并随后绑定
 * 创建并分配一个 NioEventLoopGroup 实例来处理事件的处理，如接受新的连接和读/写数据。
 * 指定本地 InetSocketAddress 给服务器绑定
 * 通过 EchoServerHandler 实例给每一个新的 Channel 初始化
 * 最后调用 ServerBootstrap.bind() 绑定服务器
 * <p>
 * Created by vectorzhang on 2017/5/7.
 */
public class EchoServer {

    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: " + EchoServer.class.getSimpleName() + "<port>");
            return;
        }
        int port = Integer.parseInt(args[0]);        //1
        new EchoServer(port).start();                //2
    }

    public void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup(); //3
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)                                //4
                    .channel(NioServerSocketChannel.class)        //5
                    .localAddress(new InetSocketAddress(port))    //6
                    .childHandler(new ChannelInitializer<SocketChannel>() { //7
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new EchoServerHandler());
                        }
                    });

            ChannelFuture f = b.bind().sync();            //8
            System.out.println(EchoServer.class.getSimpleName() + " started and listen on " + f.channel().localAddress());
            f.channel().closeFuture().sync();            //9
        } finally {
            group.shutdownGracefully().sync();            //10
        }
    }
}
