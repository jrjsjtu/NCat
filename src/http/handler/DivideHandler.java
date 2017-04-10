package http.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;


import java.nio.channels.Channels;

import static io.netty.handler.codec.http.HttpResponseStatus.INTERNAL_SERVER_ERROR;

/**
 * Created by jrj on 17-4-4.
 */
public class DivideHandler extends ChannelInboundHandlerAdapter {
    // Must use channelRead instead of SimpleChannelInboundHandler, because SimpleChannelInboundHandler may release the msg or something,
    // if we use two simpleChannelInboundHandler in one pipeline, some resource may be recycle twice and throw error
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        if (msg instanceof HttpRequest){
            String header =  ((HttpRequest) msg).getUri();
            System.out.println(header);
        }
        //ChannelPipeline p1 = Channels.pipeline();
        //ctx.fireChannelRead(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
    }
}
