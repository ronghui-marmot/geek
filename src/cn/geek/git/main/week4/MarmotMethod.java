package cn.geek.git.main.week4;

public class MarmotMethod {
	private  final int num = 123;
	
	public int getNum() throws InterruptedException {
		Thread.sleep(5000);
		Thread t = Thread.currentThread();
		System.out.println("当前线程"+t.getName());
		return num;
	}
}
