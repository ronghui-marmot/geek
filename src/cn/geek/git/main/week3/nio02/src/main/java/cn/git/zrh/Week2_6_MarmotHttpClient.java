package cn.git.zrh;

import java.io.IOException;
import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.methods.*;
import org.apache.hc.client5.http.impl.classic.*;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.HttpEntity;

public class Week2_6_MarmotHttpClient {
	

	public static void main(String[] args) throws Exception {
		try(final CloseableHttpClient httpClient = HttpClients.createDefault()){
			final String url = "Http://localhost:8801";
			final HttpGet httpGet = new HttpGet(url);
			System.out.println("-----------execute request " + httpGet.getMethod() + " " + httpGet.getUri());
			
			final HttpClientResponseHandler<String> responseHandle = new HttpClientResponseHandler<String>() {
				@Override
				public String handleResponse(ClassicHttpResponse response) throws HttpException, IOException {
					int status = response.getCode();
	//				状态码200（OK）到300（重定向）之间的 都为访问成功
					if(status >= HttpStatus.SC_SUCCESS && status<HttpStatus.SC_REDIRECTION) {
						final HttpEntity entity = response.getEntity();
						try {
							return entity!=null?EntityUtils.toString(entity):null;
						}catch(ParseException e) {
							throw new ClientProtocolException(e);
						}
					}else {
						throw new ClientProtocolException("Unexcepted response status:" + status);
					}
				}
			};
			
			final String responseBody = httpClient.execute(httpGet,responseHandle);
			System.out.println(responseBody);
		}
	}
}
