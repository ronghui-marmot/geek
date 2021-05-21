package cn.git.zrh;

import io.github.kimmking.gateway.filter.HttpRequestFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;

public class ProxyBizFilter implements HttpRequestFilter{

	@Override
	public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub
		String uri = fullRequest.uri();
		System.out.println("executing ProxyBizFilter:FullHttpRequest uri"+uri);
		if(uri.startsWith("/test")) {
			
		}else {
			throw new RuntimeException("unknown uri"); 
		}
		HttpHeaders headers = fullRequest.headers();
        if (headers == null) {
            headers = new DefaultHttpHeaders();
        }
        headers.add("proxy-tag", this.getClass().getSimpleName());
	}

}
