package interview.pro_con;

import utils.XLog;
import utils.ThreadUtil;

public class ProvCons {

	public static void main(String[] args) {
		Reso reso = new Reso();

		Prov prov = new Prov(reso);
		Cons cons = new Cons(reso);

		new Thread(prov).start();
		new Thread(prov).start();

		new Thread(cons).start();
		new Thread(cons).start();
	}

}

class Reso {

	boolean mFlag;
	String mName;
	String mSex;
	long mCount;

	public synchronized void set(String name, String sex) {
		while (mFlag) {
			ThreadUtil.wait(this);
		}
		this.mName = name;
		this.mSex = sex;
		XLog.init().debug("Prov, " + name + ":" + sex + ", count: " + ++mCount);

		mFlag = !mFlag;

		notifyAll();
	}

	public synchronized void get() {
		while (!mFlag) {
			ThreadUtil.wait(this);
		}
		XLog.init().debug("Cons, " + mName + ":" + mSex + ", count: " + mCount);

		mFlag = !mFlag;

		notifyAll();

		ThreadUtil.sleep(500);
	}

}

class Prov implements Runnable {

	private Reso mReso;

	public Prov(Reso reso) {
		this.mReso = reso;
	}

	@Override
	public void run() {
		boolean flag = false;
		while (true) {
			synchronized (this) {
				if (flag) {
					mReso.set("hh", "female");
				} else {
					mReso.set("--------------- YY", "MALE");
				}
				flag = !flag;
			}
		}
	}

}

class Cons implements Runnable {

	private Reso mReso;

	public Cons(Reso reso) {
		this.mReso = reso;
	}

	@Override
	public void run() {
		while (true) {
			mReso.get();
		}
	}

}
