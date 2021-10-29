package bh.day_11.t09;

import utils.XLog;
import utils.ThreadUtil;

/*
 * 添加同步代码块 - 线程安全
 * 
 * 同步的前提:
 *	1, 必须要有两个或两个以上的线程
 *	2, 必须是多个线程使用同一锁
 *
 * 好处: 解决了安全问题
 * 弊端: 多个线程都要判断锁, 消耗资源
 *
 */

public class Day1109 {

	public static void main(String[] args) {
		MyRunnable runnable = new MyRunnable();

		new Thread(runnable).start();
		new Thread(runnable).start();
		new Thread(runnable).start();
	}

}

class MyRunnable implements Runnable {

	private int num = 17;

	private Object obj = new Object();

	@Override
	public void run() {
		XLog.init().debug(Thread.currentThread());

		while (true) {
			synchronized (obj) { // 添加同步锁
				if (num > 0) {
					Thread.yield();
					ThreadUtil.sleep(100);

					XLog.init().debug(Thread.currentThread() + " - num: " + num--);
				} else {
					return;
				}
			}
		}
	}

}
