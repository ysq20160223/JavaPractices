package bh.day_12.t02;

import java.util.Date;

import bh.day_12.Res;
import utils.XLog;

/*
 * 为多线程添加同步
 * 
 * Input 线程对 (name,sex) 赋值加同步
 * Output 线程对 (name,sex) 输出加同步
 * 
 */
public class Day1202 {

	public static void main(String[] args) {
		XLog.init().debug("Date: " + new Date());

		Res res = new Res();
		new Thread(new Input(res)).start();
		new Thread(new Output(res)).start();
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
			synchronized (res) {
				if (x == 0) {
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
}

class Output implements Runnable {

	private Res res;

	public Output(Res res) {
		this.res = res;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (res) {
				XLog.init().debug("name: " + res.name + ", sex: " + res.sex);
			}
		}
	}
}

//
//
