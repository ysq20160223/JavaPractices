package interview.pro_con;

import utils.XLog;

/*
	1, 定义资源类, 在资源类中分别 赋值 和 输出 (会产生打印异常问题)
	
	
 */

public class ProCon01 {

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

		public void set(String name, String sex) {
			mName = name;
			mSex = sex;
		}

		public void print() {
			XLog.init().debug(mName + ":" + mSex);
		}

	}

}

//
