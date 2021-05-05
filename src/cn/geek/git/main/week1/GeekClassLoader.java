package cn.geek.git.main.week1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class GeekClassLoader extends ClassLoader {
	
	public static void main(String[] args) {
		try {
			GeekClassLoader gcl = new GeekClassLoader();
			Object helloInstance = gcl.findClass("Hello").newInstance();
			helloInstance.getClass().getMethod("hello").invoke(helloInstance);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String filename = "Hello.xlass";
		byte[] bytes = parse(filename);
		return defineClass(name, bytes, 0,bytes.length);
	}
	
	private byte[] parse(String filename) {
		byte[] result = null;
		if(null != filename) {
			String dir = System.getProperty("user.dir");
			String prefix = dir+"/resources/";
			Path path = Paths.get(prefix+filename);
			try {
				byte[] buffer = Files.readAllBytes(path);
	        	result = new byte[buffer.length];
	        	for(int i=0;i<buffer.length;i++) {
	        		result[i]=(byte)(0xFF-buffer[i]);
	        	}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
