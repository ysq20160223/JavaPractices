package bh.day_09.t12;

import utils.XLog;

public class Day0912 {

	public static void main(String[] args) {

		try {
			Teacher t = new Teacher(new Computer(), "hh");
			t.teacher();
		} catch (NoPlan e) {
			XLog.init().debug("NoPlan Exception : " + e);
		}

	}

}

// ****************************

class Computer {

	private final int BUBBLE_SMOKE = 0;
	private final int BLUE_SCREEN = 1;
	private final int NORMAL = 2;

	private int state = BLUE_SCREEN;

	public void run() throws BlueScreen, BubbleSmoke {
		if (BLUE_SCREEN == state) {
			throw new BlueScreen("computer blue screen");
		}

		if (BUBBLE_SMOKE == state) {
			throw new BubbleSmoke("computer bubble smoke");
		}

		XLog.init().debug("Computer Run!");
	}

	public void restart() {
		state = NORMAL;
		XLog.init().debug("Computer restart");
	}
}

// ****************************

class Teacher {

	private String name;
	private Computer computer;

	public Teacher(Computer computer, String name) {
		this.computer = computer;
		this.name = name;
	}

	public void teacher() throws NoPlan {
		try {
			computer.run();
		} catch (BlueScreen e) {
			XLog.init().debug(e);
			computer.restart();
		} catch (BubbleSmoke e) {
			// System.out.println(e.toString());
			throw new NoPlan("teacher(" + name + ") no_plan : " + e);
		}
		XLog.init().debug("Teacher speak");
	}

	public String getName() {
		return name;
	}

}

// **************************** Exception
@SuppressWarnings("serial")
class BlueScreen extends Exception {

	public BlueScreen(String msg) {
		super(msg);
	}

}

@SuppressWarnings("serial")
class BubbleSmoke extends Exception {

	public BubbleSmoke(String msg) {
		super(msg);
	}
}

@SuppressWarnings("serial")
class NoPlan extends Exception {

	public NoPlan(String msg) {
		super(msg);
	}
}

//
