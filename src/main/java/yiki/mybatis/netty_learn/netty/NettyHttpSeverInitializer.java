package yiki.mybatis.netty_learn.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class NettyHttpSeverInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel sch) throws Exception {
        System.out.println("init");
        ChannelPipeline pipeline = sch.pipeline();
        pipeline.addLast("myHTTPCodec",new HttpServerCodec());
        pipeline.addLast("myHandler",new NettyHttpSeverHandler());

    }
}
