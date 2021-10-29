package bh.day_12.t04;

import java.util.Date;

import utils.XLog;
import utils.ThreadUtil;

/*
 * Review : 代码优化
 * 
 * 适用于两个线程
 * 
 */
public class Day1204 {

	public static void main(String[] args) {
		XLog.init().debug("Date : " + new Date());

		Res res = new Res();

		new Thread(new Input(res)).start();
		new Thread(new Output(res)).start();
	}
}

class Res {

	private String name;
	private String sex;
	private boolean flag;

	@Override
	public String toString() {
		return "Res [name=" + name + ", sex=" + sex + ", flag=" + flag + "]";
	}

	public synchronized void print() {
		if (!flag) {
			ThreadUtil.wait(this, "print");
		}
		XLog.init().debug("name: " + name + ", sex: " + sex);

		flag = !flag;
		notify();

		ThreadUtil.sleep(500);
	}

	public synchronized void setNameAndSex(String name, String sex) {
		if (flag) {
			ThreadUtil.wait(this, "setNameSex");
		}

		this.name = name;
		this.sex = sex;

		flag = !flag;
		notify();
	}

}

class Input implements Runnable {

	private Res res;

	public Input(Res res) {
		this.res = res;
	}

	@Override
	public void run() {
		int x = 0;
		while (true) {
			if (x == 0) {
				res.setNameAndSex("----------------- YY", "MALE");
			} else {
				res.setNameAndSex("hh", "female");
			}
			x = (x + 1) % 2;
		}
	}
}

class Output implements Runnable {

	private Res res;

	public Output(Res res) {
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
//