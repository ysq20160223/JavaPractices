package interview.pro_con;

import utils.XLog;
import utils.ThreadUtil;

/*
	02, 资源类 赋值 和 输出 添加同步 (解决打印异常问题)
 */

public class ProCon02 {

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

				ThreadUtil.sleep(500, null);
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

		public synchronized void set(String name, String sex) {
			mName = name;
			mSex = sex;
		}

		public synchronized void print() {
			XLog.init().debug(mName + " : " + mSex);
		}

	}

}

//
