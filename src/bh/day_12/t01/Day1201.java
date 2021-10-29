package bh.day_12.t01;

import java.util.Date;

import bh.day_12.Res;
import utils.XLog;

/*
 * 线程间通讯：
 * 其实就是多个线程在操作同一个资源，但是操作的动作不同
 * 
 * 没有添加同步
 * 
 * 在 Input 线程还没对 name、sex 赋值结束， Output 线程就获取 CPU 执行权
 */
public class Day1201 {

	public static void main(String[] args) {
		XLog.init().debug("Date: " + new Date());

		Res res = new Res();
		new Thread(new InputRunnable(res)).start();
		new Thread(new OutputRunnable(res)).start();
	}
}

class InputRunnable implements Runnable {

	private Res res;

	public InputRunnable(Res res) {
		this.res = res;
	}

	@Override
	public void run() {
		int x = 0;
		while (true) {
			if (x == 1) {
				res.name = "----------------- YY";
				res.sex = "MALE";
			} else {
				res.name = "hh";
				res.sex = "female";
			}
			x = (x + 1) % 2;
		}
	}
}

class OutputRunnable implements Runnable {

	private Res res;

	public OutputRunnable(Res res) {
		this.res = res;
	}

	@Override
	public void run() {
		while (true) {
			XLog.init().debug("name: " + res.name + ", sex: " + res.sex);
		}
	}
}

//
//
