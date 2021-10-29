package bh.day_11.t11;

import utils.XLog;
import utils.ThreadUtil;

/*
 * 添加同步函数 - 线程安全
 * 
 * 模拟三个人同时往同一个账户存款
 */
public class Day1111 {

	public static void main(String[] args) {
		SaveRunnable runnable = new SaveRunnable();
		for (int i = 0; i < 3; i++) {
			new Thread(runnable).start();
		}
	}

}

class SaveRunnable implements Runnable {

	Account account = new Account();

	@Override
	public void run() {
		XLog.init().debug(Thread.currentThread());

		for (int i = 0; i < 7; i++) {
			account.add();
			Thread.yield();
		}
	}
}

//
class Account {

	private int sum = 0;

	public synchronized void add() { // synchronized
		ThreadUtil.sleep(50, "add");

		XLog.init().debug(Thread.currentThread() + " - Balance: " + ++sum);
	}

}

//
