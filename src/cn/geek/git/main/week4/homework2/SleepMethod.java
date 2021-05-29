package cn.geek.git.main.week4.homework2;

import java.util.concurrent.locks.LockSupport;

public class SleepMethod {
	
	
	public static void main(String[] args) throws InterruptedException {
		MarmotMethod mm = new MarmotMethod();
		Runnable r = new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("--------获得返回值为："+mm.getNum()+"-----------------");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread t = new Thread(r);
		t.setDaemon(true);
		t.start();
//		方法一：在主线程调用sleep方法
//		Thread.sleep(6000);
//		方法二：ExecutorMethod类
//		利用线程池的shutdown方法，该方法停止接受新任务，并且已经提交的任务要等到完成才结束
//		方法三：利用线程的join方法，本质也是获取t.wait()方法
//		t.join();
//		方法四：LockMethod类 利用wait notify方法，需要注意的是需要先获得该对象的锁
//		方法五：LockMethod2类 利用Lock锁机制	
//		方法六：LockMethod类利用LockSupport.park/unpark方法 ?没成功？？？
		
	}
}
