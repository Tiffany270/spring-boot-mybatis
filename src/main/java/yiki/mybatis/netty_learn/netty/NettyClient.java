package yiki.mybatis.netty_learn.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {

    public static void start() throws Exception {

        //The client only need one event loopGroup
        EventLoopGroup eventExecutors = new NioEventLoopGroup();

        try {
            // create stater obj of client
            Bootstrap bootstrap = new Bootstrap();
            // set config params
            bootstrap.group(eventExecutors)//set thread group
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel sch) throws Exception {
                            sch.pipeline().addLast(new NettyClientHandler());
                        }
                    });
            System.out.println("client is ready....");
            //start client to connect sever
            ChannelFuture future = bootstrap.connect("127.0.0.1", 6668).sync();
            future.channel().closeFuture().sync();
        } finally {
            eventExecutors.shutdownGracefully();

        }
    }

}
