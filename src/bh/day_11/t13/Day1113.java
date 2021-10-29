package bh.day_11.t13;

import utils.XLog;
import utils.ThreadUtil;

/*
 * 静态同步函数的锁是 ( 类名.class )
 */

public class Day1113 {

	public static void main(String[] args) throws Exception {

		SellTicket st = new SellTicket();

		st.setFlag(true); // false true
		new Thread(st).start();

		Thread.sleep(1);

		st.setFlag(false);
		new Thread(st).start();
	}

}

class SellTicket implements Runnable {

	private boolean flag;
	private static int ticket = 20;
	private static int delayTime = 150;

	public void run() {
		Thread.yield();
		if (flag) {
			XLog.init().debug(Thread.currentThread() + " - code");

			while (true) {
				synchronized (SellTicket.class) {
					if (ticket > 0) {
						ThreadUtil.sleep(delayTime, "synchronized");

						XLog.init().debug(Thread.currentThread() + " - code: " + ticket--);
					} else {
						break;
					}
				}
			}
		} else {
			XLog.init().debug(Thread.currentThread() + " ********************** func");

			while (true) {
				if (ticket > 0) {
					sellTicket();
				} else {
					break;
				}
			}
		}
	}

	public static synchronized void sellTicket() {
		if (ticket > 0) {
			ThreadUtil.sleep(delayTime, "sellTicket");

			XLog.init().debug(Thread.currentThread() + " ********************** func: " + ticket--);
		}
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}

//
