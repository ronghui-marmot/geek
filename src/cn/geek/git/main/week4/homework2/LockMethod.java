package cn.geek.git.main.week4.homework2;

import java.util.concurrent.locks.LockSupport;

/**
 * 方法四：LockMethod类 利用wait notify方法，需要注意的是需要先获得该对象的锁
 * @author rongh
 *
 */
public class LockMethod {
	
	public static void main(String[] args) {
		Object object = new Object();
		Thread t = new Thread(()->{
//			LockSupport.park();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int num = 1000000;
			int sum = 0;
			for(int i=0; i<num; i++) {
				sum += i;
			}
			
			System.out.println("----子线程结束---，值为"+sum);
			synchronized(object) {
				object.notify();
			}
		});
		t.setDaemon(true);
		t.start();
		try {
			synchronized(object) {
				object.wait();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		LockSupport.unpark(t);
	}
	
}
