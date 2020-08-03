package yiki.mybatis.netty_learn.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class GroupChatSeverHandler extends SimpleChannelInboundHandler<String> {

    public static List<Channel> channels = new ArrayList<Channel>();

    private static ChannelGroup channelGroup =
            new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    SimpleDateFormat formatter =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        //push to others clients
        channelGroup.writeAndFlush("[client]:"
                + channel.remoteAddress() +
                "is joining");
        channelGroup.add(channel);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        Channel channel = ctx.channel();
        //according different msg to return msg
        channelGroup.forEach(ch -> {
            if (channel != ch) {//current is no need to return
                ch.writeAndFlush("[client]"
                        + channel.remoteAddress() + ":" + s);
            } else {
                //yourself
                ch.writeAndFlush("[yourself]:" + s);
            }
        });

    }

    //when sb is online/active
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "is online");
    }

    // when sb is off-line
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "is off-line");

    }

    //when sb is out off connection
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush(channel.remoteAddress() + "is out of connection");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();

    }
}
