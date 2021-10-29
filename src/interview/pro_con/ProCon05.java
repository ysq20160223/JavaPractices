package interview.pro_con;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import utils.XLog;

/*
	05, 添加JDK1.5新特性, 解决两个生产者和两个消费者唤醒对方的问题
 */

public class ProCon05 {

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
						mRes.set("jj", "female");
					} else {
						mRes.set("------------------- YY", "MALE");
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

		private Lock mLock = new ReentrantLock();
		private Condition mConditionPro = mLock.newCondition();
		private Condition mConditionCon = mLock.newCondition();

		private String mName;
		private String mSex;

		private boolean mFlag;
		private int count;

		public void set(String name, String sex) {
			mLock.lock();
			try {
				while (mFlag) {
					mConditionPro.await();
				}
				mName = name;
				mSex = sex;

				mFlag = !mFlag;
				count++;

				XLog.init().debug("Pro, " + mName + ":" + mSex + ", count: " + count + ", " + Thread.currentThread());

				mConditionCon.signal();
			} catch (Exception e) {
				XLog.init().debug(e.toString());
			} finally {
				mLock.unlock();
			}

		}

		public void print() {
			mLock.lock();
			try {
				while (!mFlag) {
					mConditionCon.await();
				}
				XLog.init().debug("Con, " + mName + ":" + mSex + ", count: " + count + ", " + Thread.currentThread());
				mFlag = !mFlag;

				mConditionPro.signal();

				Thread.sleep(100);
			} catch (Exception e) {
				XLog.init().debug(e.toString());
			} finally {
				mLock.unlock();
			}
		}

	}

}

//
