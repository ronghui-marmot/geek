package cn.geek.git.main;

import java.io.File;
import java.io.FileInputStream;


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
			String path = System.getProperty("user.dir");
			String prefix = path+"/resources/";
			try {
				File f = new File(prefix+filename);
				long fileSize = f.length();
				FileInputStream fi = new FileInputStream(f);
				byte[] buffer = new byte[(int)fileSize];
		        	fi.read(buffer);
		        	fi.close();
		        result = new byte[buffer.length];
		        for(int i=0;i<buffer.length;i++) {
		        	result[i]=(byte)(255-Byte.toUnsignedInt(buffer[i]));
		        }
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
