package yiki.mybatis.netty_learn.netty;


/*
 *   NOTE:


 * */

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {
    public static void start() throws Exception {



        /* create BossGroup and WorkGroup,
         these are thread group, both is loop
         'boss' is to handle request of connection
         'woke' is to handle real work with client */
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        try {

            // create the start obj of server, and configure params
            ServerBootstrap bootstrap = new ServerBootstrap();
            // linked module configuration
            bootstrap.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    //connection nums of thread waiting
                    .option(ChannelOption.SO_BACKLOG, 128)
                    //keep alive status
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    //set handle to the pip of specif woke eventLoop
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        // set handler for pipeline
                        @Override
                        protected void initChannel(SocketChannel sch) throws Exception {
                            sch.pipeline().addLast(new NettyServerHandler());
                        }
                    });
            // ##s3 non-reactor->channel
            //get ch.hashCode as identified


            System.out.println("server is ready ....");
            // bind port and set sync
            ChannelFuture cf = bootstrap.bind(6668).sync();
            // NOTE: future is async result,
            // it provide API to check the perform is finished or not
            // such:
            cf.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (cf.isSuccess()) {
                        //do sth...
                    }

                }
            });

            //----- 在服务端执行后执行客户端
            NettyClient.start();
            //----可删


            //listen the close event for pip
            //(when you close your channel the serve would know it)
            cf.channel().closeFuture().sync();

        } finally {
            workGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();

        }
    }
}
