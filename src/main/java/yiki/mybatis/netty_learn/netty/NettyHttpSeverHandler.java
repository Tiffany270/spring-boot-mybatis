package yiki.mybatis.netty_learn.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

public class NettyHttpSeverHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx,
                                HttpObject httpObject) throws Exception {
        System.out.println(httpObject);
        if (httpObject instanceof HttpRequest) {
            System.out.println("add: " + ctx.channel().remoteAddress());

            //filter
            HttpRequest httpRequest = (HttpRequest) httpObject;
            URI uri = new URI(httpRequest.uri());
            if ("/favicon.ico".equals(uri.getPath())) {
                System.out.println("no data return");
                return;
            }

            ByteBuf reply = Unpooled.copiedBuffer("hi, I am sever", CharsetUtil.UTF_8);
            FullHttpResponse res = new DefaultFullHttpResponse(
                    HttpVersion.HTTP_1_1,
                    HttpResponseStatus.OK,
                    reply);

            res.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            res.headers().set(HttpHeaderNames.CONTENT_LENGTH, reply.readableBytes());

            //send it
            ctx.writeAndFlush(res);

        }
    }
}
