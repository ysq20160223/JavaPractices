package bh.day_12.t08;

import utils.XLog;

/*
 * 守护线程
 * public final void setDaemon(boolean on) 
 * 		将该线程标记为守护线程或用户线程。当正在运行的线程都是守护线程时，Java 虚拟机退出。 
 * 		该方法必须在启动线程前调用。
 * 		该方法首先调用该线程的 checkAccess 方法，且不带任何参数。这可能抛出 SecurityException（在当前线程中）。 
 */
public class Day1208 {

	public static void main(String[] args) {

		StopRunnable runnable = new StopRunnable();

		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);

		t1.setDaemon(true);
		t2.setDaemon(true);

		t1.start();
		t2.start();

		int num = 0;

		while (true) {
			if (num++ == 60) {
				break;
			}
			XLog.init().debug(Thread.currentThread().getName() + ", num: " + num);
		}
		XLog.init().debug("over");
	}

}

class StopRunnable implements Runnable {

	private boolean flag = true;

	@Override
	public synchronized void run() {
		while (flag) {
			try {
				wait();
			} catch (Exception e) {
				XLog.init().debug(Thread.currentThread().getName() + " Exception");
				flag = false;
			}
			XLog.init().debug(Thread.currentThread().getName() + " run");
		}
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}

//
