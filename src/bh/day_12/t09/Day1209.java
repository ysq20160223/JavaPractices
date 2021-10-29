package bh.day_12.t09;

import utils.XLog;

/*
 * join
 * 当 A 线程执行到了 B 线程的 join 方法时，A 就会等待，等 B 线程都执行完，A 才会执行
 * 
 * join 可以用来临时加入线程执行
 * 
 * public final void join() throws InterruptedException (等待该线程终止)
 * 		如果任何线程中断了当前线程。当抛出该异常时，当前线程的中断状态 被清除。
 * 
 */

public class Day1209 {

	public static void main(String[] args) throws Exception {

		JoinRunnable joinRunnable = new JoinRunnable();

		Thread t1 = new Thread(joinRunnable);
		Thread t2 = new Thread(joinRunnable);

		t1.start();
		t2.start();

		t1.join();

		for (int i = 0; i < 100; i++) {
			XLog.init().debug(Thread.currentThread() + " - " + i);
		}
	}

}

class JoinRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			XLog.init().debug(Thread.currentThread() + " - " + i);
		}
	}

}

//
//
