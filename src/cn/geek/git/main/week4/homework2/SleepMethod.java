package cn.geek.git.main.week4.homework2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SleepMethod {
	private final static int poolSize  = 1;
	
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
//		方法一：在主线程调用sleep方法
//		t.start();
//		Thread.sleep(6000);
//		方法二：利用线程池的shutdown方法，该方法停止接受新任务，并且已经提交的任务要等到完成才结束
		ExecutorService  pool = Executors.newFixedThreadPool(poolSize);
		pool.submit(t);
		pool.shutdown();
//		方法三：利用线程的join方法
		t.join();
	}
}
