package bh.day_12.t03;

import java.util.Date;

import bh.day_12.Res;
import utils.XLog;
import utils.ThreadUtil;

/*
 为多线程添加同步

 Input 线程对 (name,sex) 赋值加同步
 Output 线程对 (name,sex) 输出加同步

 线程 Input 先判断(name,sex)的标识，未赋值为 false，若为 false 则执行对(name,sex) 赋值，并设置标识为 true
 若 Input 继续获取执行权判断标识为 true 则 wait，同时唤醒 Output 线程执行 输出

 线程 Output 先判断(name,sex)的标识，已赋值为true，若为 true 则执行对(name,sex) 输出，并设置标识为 false
 若 Output 继续获取执行权判断标识为 false 则 wait，同时唤醒 Input 线程执行 赋值
 ---------------------------------------------------------

 等待唤醒机制

 wait : 
 notify : 唤醒线程池中第一个等待的线程
 notifyAll : 唤醒线程中的所有等待的线程

 都使用在同步中，因为要对持有监视器（锁）的线程操作。
 所以要使用在同步中，因为只有同步才具有锁

 为什么这些操作线程的方法要定义在 Object 类中？
 因为这些方法在操作同步线程时，都必须要表示它们锁操作线程持有的锁，
 只有同一个锁上的被等待线程，可以被同一锁上notify唤醒
 不可以对不同锁中的线程进行唤醒

 也就是说，等待和唤醒必须是同一锁

 而锁可以是任意对象，所以可以被任意对象调用的方法定义在 Object 类中

 */
public class Day1203 {

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
				if (res.flag) {
					ThreadUtil.wait(res);
				}
				if (x == 0) {
					res.name = "----------------- YY";
					res.sex = "MALE";
				} else {
					res.name = "hh";
					res.sex = "female";
				}
				x = (x + 1) % 2;
				res.flag = true;

				ThreadUtil.sleep(100);

				res.notify(); // 唤醒线程池中第一个等待的线程
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
				if (!res.flag) {
					ThreadUtil.wait(res);
				}
				XLog.init().debug("name: " + res.name + ", sex: " + res.sex);
				res.flag = false;
				res.notify();
			}
		}
	}
}

//
//
