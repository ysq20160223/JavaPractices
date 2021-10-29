package bh.day_11.t02;

import utils.XLog;
import utils.ThreadUtil;

/*
 * 匿名 Thread 子类
 * 
 * 为何覆盖 run 方法: 存储自定义代码
 * 
 * 
 * */

public class Day1102 {

	public static void main(String[] args) {
		new TestThread().start();

		for (int i = 0; i < 9; i++) {
			XLog.init().debug("i: " + i + ", " + Thread.currentThread());
			ThreadUtil.sleep(150);
		}
	}
}

class TestThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 9; i++) {
			XLog.init().debug(" ---------------------- i: " + i + ", " + Thread.currentThread());
			ThreadUtil.sleep(150);
		}
	}
}
