package ru.ttk.netty.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * Listing 2.3  of <i>Netty in Action</i>
 *
 * @author <a href="mailto:nmaurer@redhat.com">Norman Maurer</a>
 */
public class EchoServer {

    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    /**
     *
     * @throws Exception
     */
    public void start() throws Exception {
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        try {

            serverBootstrap.group(new NioEventLoopGroup(), new NioEventLoopGroup());

            serverBootstrap.channel(NioServerSocketChannel.class);

            serverBootstrap.localAddress(new InetSocketAddress(port));

            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new EchoServerHandler());
                    }
            });

            ChannelFuture channelFuture = serverBootstrap.bind().sync();

            System.out.println(EchoServer.class.getName() + " started and listen on " + channelFuture.channel().localAddress());
            channelFuture.channel().closeFuture().sync();

        } finally {
            serverBootstrap.shutdown();
        }
    }

    public static void main(String[] args) throws Exception {
//        if (args.length != 1) {
//            System.err.println(
//                    "Usage: " + EchoServer.class.getSimpleName() +
//                            " <port>");
//            return;
//        }
//        int port = Integer.parseInt(args[0]);

        int port = 20000;//Integer.parseInt(args[0]);
        new EchoServer(port).start();
    }
}

