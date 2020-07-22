package yiki.mybatis.netty_learn.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/*
 * NOTE:
 * */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    // read msg from client
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        // transfer msg to ByteBuf
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("from server: " + buf.toString(CharsetUtil.UTF_8));
        System.out.println("server add: " + ctx.channel().remoteAddress());
    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // msg push-> channel(not pipe)
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello", CharsetUtil.UTF_8));

    }

    // Once have exception, close the channel
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
