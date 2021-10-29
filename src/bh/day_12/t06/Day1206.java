package bh.day_12.t06;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import utils.XLog;
import utils.ThreadUtil;

/*
 * Review : JDK1.5 新特性
 * 
 * JDK1.5 中提供了多线程升级解决方案
 * 将同步 synchronized 替换成现实 Lock 操作
 * 将 Object 中的 wait, notify, notifyAll 替换了 Condition 对象
 * 该对象可以 Lock 锁进行获取
 * 
 * 该示例中，实现了本方只唤醒对方操作
 * 
 */
public class Day1206 {
	public static void main(String[] args) {

		Res res = new Res();

		new Thread(new Producer(res)).start();
		new Thread(new Producer(res)).start();

		new Thread(new Consumer(res)).start();
		new Thread(new Consumer(res)).start();
	}
}

class Res {

	private String name;
	private int count;
	private boolean flag;

	private Lock lock = new ReentrantLock();
	private Condition conditionPro = lock.newCondition();
	private Condition conditionCon = lock.newCondition();

	public void set(String name) {
		lock.lock();
		try {
			while (flag) {
				conditionPro.await();
			}
			this.name = name + " - " + ++count;
			XLog.init().debug(Thread.currentThread() + " " + this.name);

			flag = true;
			conditionCon.signal();
		} catch (Exception e) {
			XLog.init().debug(e.toString());
		} finally {
			lock.unlock(); // 释放锁的动作一定要执行
		}
	}

	public void print(String name) {
		lock.lock();
		try {
			while (!flag) {
				conditionCon.await();
			}
			this.name = name + " - " + count;
			XLog.init().debug(Thread.currentThread() + " ---------- " + this.name);

			ThreadUtil.sleep(500);
			flag = false;
			conditionPro.signal();
		} catch (Exception e) {
			XLog.init().debug(e.toString());
		} finally {
			lock.unlock();
		}
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
			res.set("Producer");
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
			res.print("Consumer");
		}
	}
}

//

//
