package cn.geek.others;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;

public class HttpServer01 {
	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = new ServerSocket(8801);
		
		while(true) {
			try {
				final Socket socket = serverSocket.accept();
				new Thread(()->{
				service(socket);
				}).start();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	private static void service(Socket socket) {
		try {
			
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			printWriter.println("HTTP/1.1 200 OK");
			printWriter.println("Content-Type:text/html;charset=utf-8");
			String body = "hello,nio";
			printWriter.println("Content-length:"+body.length());
			printWriter.println();
			printWriter.write(body);
			printWriter.close();
			socket.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
