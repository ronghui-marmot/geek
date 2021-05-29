package cn.geek.git.main.week4.homework2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/**
 * 方法二：ExecutorMethod类
 * 利用线程池的shutdown方法，该方法停止接受新任务，并且已经提交的任务要等到完成才结束
 * @author rongh
 *
 */
public class ExecutorMethod {
	private final static int poolSize  = 1;
	public static void main(String[] args) {
		Thread t = new Thread(()-> {
			int num = 10000;
			int sum = 0;
			for(int i=0; i<num; i++) {
				sum += i;
			}
			System.out.println("----求和结束，和为" + sum +"-----");
		});
		
		ExecutorService  pool = Executors.newFixedThreadPool(poolSize);
		pool.submit(t);
		long start = System.currentTimeMillis();
		pool.shutdown();
		try {
			if(pool.awaitTermination(1, TimeUnit.SECONDS)) {
				long end = System.currentTimeMillis();
				System.out.println("------线程池成功关闭，耗时："+ (end-start)+"毫秒------");
			}
				
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
}
