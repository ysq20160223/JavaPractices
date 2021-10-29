package bh.day_12.t05;

import utils.XLog;
import utils.ThreadUtil;

/*
 Review : 两个生产者线程，两个消费者线程
 */
public class Day1205 {

	public static void main(String[] args) {
		Res res = new Res();

		new Thread(new Producer(res)).start();
		new Thread(new Producer(res)).start();

		new Thread(new Consumer(res)).start();
		new Thread(new Consumer(res)).start();
	}
}

class Res {

	private int count;
	private boolean flag;

	public synchronized void set() {
		while (flag) {
			ThreadUtil.wait(this);
		}

		XLog.init().debug(Thread.currentThread() + " Producer - " + ++count);

		flag = !flag;
		notifyAll();
	}

	public synchronized void print() {
		while (!flag) {
			ThreadUtil.wait(this);
		}
		XLog.init().debug(Thread.currentThread() + " ---------- Consumer - " + count);

		ThreadUtil.sleep(500);

		flag = !flag;
		notifyAll();
	}
}

class Producer implements Runnable {

	private Res res;

	public Producer(Res res) {
		this.res = res;
	}

	@Override
	public void run() {
		while (true) {
			res.set();
		}
	}
}

class Consumer implements Runnable {

	private Res res;

	public Consumer(Res res) {
		this.res = res;
	}

	@Override
	public void run() {
		while (true) {
			res.print();
		}
	}
}

//
