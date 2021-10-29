package interview.pro_con;

import utils.XLog;
import utils.ThreadUtil;

/*
	03, 资源类定义标志位 (解决生产一个消费一个的问题)
 */

public class ProCon03 {

	public static void main(String[] args) {

		Res res = new Res();
		new Thread(new Product(res)).start();
		new Thread(new Consume(res)).start();
	}

	static class Product implements Runnable {

		private Res mRes;

		public Product(Res res) {
			mRes = res;
		}

		@Override
		public void run() {
			boolean flag = true;
			while (true) {
				if (flag) {
					mRes.set("jj", "female");
				} else {
					mRes.set("------------------- YY", "MALE");
				}
				flag = !flag;

				ThreadUtil.sleep(10, null);
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

		public synchronized void set(String name, String sex) {
			if (mFlag) {
				try {
					wait();
				} catch (Exception e) {
					XLog.init().debug(e.toString());
				}
			}
			mName = name;
			mSex = sex;

			mFlag = !mFlag;
			notify();
		}

		public synchronized void print() {
			if (!mFlag) {
				try {
					wait();
				} catch (Exception e) {
					XLog.init().debug(e.toString());
				}
			}
			XLog.init().debug(mName + ":" + mSex);
			mFlag = !mFlag;
			notify();

			ThreadUtil.sleep(100);
		}

	}

}

//
