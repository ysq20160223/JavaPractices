package bh.day_12.t10;

import utils.XLog;

/*
 * yield() (暂停当前正在执行的线程对象，并执行其他线程)
 * 
 */
public class Day1210 {

	public static void main(String[] args) throws Exception {

		JoinRunnable joinRunnable = new JoinRunnable();

		Thread t1 = new Thread(joinRunnable);
		Thread t2 = new Thread(joinRunnable);

		t1.start();
		t2.start();

		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);

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
			Thread.yield();
		}
	}
}

//
//
