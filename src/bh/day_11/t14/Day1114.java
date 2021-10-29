package bh.day_11.t14;

public class Day1114 {

	public static void main(String[] args) {

	}

}

class Test {

	// 1
	private static final Test test = new Test();

	// 2
	private Test() {
	}

	// 3
	public static Test getInstance() {
		return test;
	}
}

class Model {

	// 1
	private static Model model;

	// 2
	private Model() {
	}

	// 3
	public static Model getInstance() {
		if (null == model) {
			synchronized (Model.class) {
				if (null == model) {
					model = new Model();
				}
			}
		}
		return model;
	}
}

//
