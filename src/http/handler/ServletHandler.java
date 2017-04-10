package http.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpRequest;

/**
 * Created by jrj on 17-3-22.
 */
public class ServletHandler extends ChannelInboundHandlerAdapter {
    // Must use channelRead instead of SimpleChannelInboundHandler, because SimpleChannelInboundHandler may release the msg or something,
    // if we use two simpleChannelInboundHandler in one pipeline, some resource may be recycle twice and throw error
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        if (msg instanceof HttpRequest){
            int a =5;
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
