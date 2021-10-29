package bh.day_11.t15;

import utils.XLog;

/*
 * 死锁实例
 */
public class Day1115 {

	public static void main(String[] args) throws Exception {
		new Thread(new TestRunnable(true)).start();
		new Thread(new TestRunnable(false)).start();
	}

}

class Lock {
	static Object a = new Object();
	static Object b = new Object();
}

class TestRunnable implements Runnable {

	private boolean flag;

	public TestRunnable(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		XLog.init().debug(Thread.currentThread());

		if (flag) {
			// ThreadUtil.sleep(1000);

			synchronized (Lock.a) {
				XLog.init().debug(Thread.currentThread() + " - a used");
				synchronized (Lock.b) {
					XLog.init().debug(Thread.currentThread() + " - b used");
				}
				XLog.init().debug(Thread.currentThread() + " - b release");
			}
			XLog.init().debug(Thread.currentThread() + " - a release");
		} else {
			synchronized (Lock.b) {
				XLog.init().debug(Thread.currentThread() + " =========== b used");

				synchronized (Lock.a) {
					XLog.init().debug(Thread.currentThread() + " =========== a used");
				}
				XLog.init().debug(Thread.currentThread() + " =========== a release");
			}
			XLog.init().debug(Thread.currentThread() + " =========== b release");
		}
	}
}
