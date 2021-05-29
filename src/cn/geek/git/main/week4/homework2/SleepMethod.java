package cn.geek.git.main.week4.homework2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;

public class SleepMethod {
	
	
	public static void main(String[] args) throws InterruptedException {
		MarmotMethod mm = new MarmotMethod();
//		------------方法七start
//		CountDownLatch cl = new CountDownLatch(1);
//		------------方法七end--------
//		------------方法八start----------
		CyclicBarrier barrier = new CyclicBarrier(2);
//		-------------方法八end-----------
		Runnable r = new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("--------获得返回值为："+mm.getNum()+"-----------------");
//					------------方法七start--------
//					cl.countDown();
//					------------方法七end--------
//					------------方法八start---------
					try {
						barrier.await();
					} catch (BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//					-------------方法八end-----------
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		
		Thread t = new Thread(r);
		t.setDaemon(true);
		t.start();
//		-------------方法七start---
//		cl.await();
//		---------方法七end---
//		方法一：在主线程调用sleep方法
//		Thread.sleep(6000);
//		方法二：ExecutorMethod类
//		利用线程池的shutdown方法，该方法停止接受新任务，并且已经提交的任务要等到完成才结束
//		方法三：利用线程的join方法，本质也是获取t.wait()方法
//		t.join();
//		方法四：LockMethod类 利用wait notify方法，需要注意的是需要先获得该对象的锁
//		方法五：LockMethod2类 利用Lock锁机制	
//		方法六：LockMethod类利用LockSupport.park/unpark方法 ?没成功？？？
//		方法七：SleepMethod类 利用CountDownLatch的await与countdown方法
//		方法八：SleepMethod类 利用CyclicBarrier将主线程与子线程作为
//		----------方法八start----------
//		try {
//			barrier.await();
//		} catch (BrokenBarrierException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		-------方法八end----------
	}
}
