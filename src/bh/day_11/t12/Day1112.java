package bh.day_11.t12;

import utils.XLog;
import utils.ThreadUtil;

/*
 * 一个线程在同步代码块中执行，一个线程在同步函数中执行
 * 
 * 同步函数的锁是 this
 */
public class Day1112 {

	public static void main(String[] args) {

		MyRunnable runnable = new MyRunnable();

		runnable.setFlag(true);
		new Thread(runnable).start();

		ThreadUtil.sleep(5);

		runnable.setFlag(false);
		new Thread(runnable).start();
	}

}

class MyRunnable implements Runnable {

	private boolean flag;
	private int ticket = 100;
	private int delay = 50;

	@Override
	public void run() {
		Thread.yield();
		if (flag) {
			XLog.init().debug(Thread.currentThread() + " - code");

			while (true) {
				synchronized (this) {
					if (ticket > 0) {
						ThreadUtil.sleep(delay, "code");

						XLog.init().debug(Thread.currentThread() + " - code: " + ticket--);
					} else {
						break;
					}
				}
			}
		} else {
			XLog.init().debug(Thread.currentThread() + " ********************** func");

			while (true) {
				if (ticket > 0) {
					sellTicket();
				} else {
					break;
				}
			}
		}
	}

	public synchronized void sellTicket() {
		if (ticket > 0) {
			ThreadUtil.sleep(delay, "func");

			XLog.init().debug(Thread.currentThread() + " ********************** func: " + ticket--);
		}
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
