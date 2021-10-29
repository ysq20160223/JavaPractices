package interview.pro_con;

import utils.XLog;
import utils.ThreadUtil;

/*
	04, 两个生产者和两个消费者的问题
	
	功能
		1, 生产者和消费者交替进行
		2, 两个生产者也要交替进行
	
 */

public class ProCon04 {

	public static void main(String[] args) {

		Res res = new Res();

		Product product = new Product(res);
		Consume consume = new Consume(res);

		new Thread(product).start();
		new Thread(product).start();
		// new Thread(product).start();
		// new Thread(product).start();

		new Thread(consume).start();
		new Thread(consume).start();

	}

	static class Product implements Runnable {

		private Res mRes;
		boolean flag = true;

		public Product(Res res) {
			mRes = res;
		}

		@Override
		public void run() {
			while (true) {
				synchronized (this) {
					if (flag) {
						mRes.set("jj", "female " + flag);
					} else {
						mRes.set("------------------- YY", "MALE " + flag);
					}
					flag = !flag;
				}
			}
		}

	}

	static class Consume implements Runnable {

		private Res mRes;

		public Consume(Res res) {
			mRes = res;
		}

		@Override
		public void run() {
			while (true) {
				mRes.print();
			}
		}

	}

	static class Res {

		private String mName;
		private String mSex;

		private boolean mFlag;
		private int count;

		public synchronized void set(String name, String sex) {
			while (mFlag) {
				ThreadUtil.wait(this);
			}
			mName = name;
			mSex = sex;
			count++;
			XLog.init().debug("Pro, " + mName + ":" + mSex + ", " + count + " " + Thread.currentThread());

			mFlag = !mFlag;
			notifyAll();
		}

		public synchronized void print() {
			while (!mFlag) {
				ThreadUtil.wait(this);
			}
			XLog.init().debug("Con, " + mName + ":" + mSex + ", " + count + " " + Thread.currentThread() + "\r\n");
			mFlag = !mFlag;
			notifyAll();

			ThreadUtil.sleep(50);
		}

	}

}

//
