package yiki.mybatis.netty_learn.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

/*
 * NOTE:
 * */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    // read msg from client
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        // transfer msg to ByteBuf
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("from client: " + buf.toString(CharsetUtil.UTF_8));
        System.out.println("client add:" + ctx.channel().remoteAddress());

        // ##s1: customer common task
//        ctx.channel().eventLoop().execute(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    // do sth...
//                }catch (Exception e){
//                    System.out.println(e);
//                }
//            }
//        });

        //##s2 customer set own timer
//        ctx.channel().eventLoop().schedule(new Runnable() {
//            @Override
//            public void run() {
//                try{
//                    // do sth...
//                }catch (Exception e){
//
//                }
//            }
//        },5, TimeUnit.SECONDS);






    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // msg push-> channel(not pipe)
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello, client", CharsetUtil.UTF_8));

    }

    // Once have exception, close the channel
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
