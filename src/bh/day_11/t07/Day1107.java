package bh.day_11.t07;

import utils.XLog;
import utils.ThreadUtil;

/*
 * 多线程操作共有资源，会产生安全隐患 (未加同步操作 )
 */
public class Day1107 {
	public static void main(String[] args) {
		new MyThread("First").start();

		new MyThread("Second").start();

		new MyThread("Third").start();
	}
}

class MyThread extends Thread {

	private static int num = 10;

	public MyThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		XLog.init().debug(Thread.currentThread());

		while (true) {
			if (num > 0) {
				Thread.yield();
				ThreadUtil.sleep(100);
				XLog.init().debug(getName() + " ==== num: " + num--);
			} else {
				return;
				// break;
			}
		}
	}

}

//
