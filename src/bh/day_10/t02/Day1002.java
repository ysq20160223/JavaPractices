package bh.day_10.t02;

public class Day1002 {

	public static void main(String[] args) {

	}

}

class Test {
	public void method() throws Exception {
		try {
			throw new Exception("Exception");
		} finally {
			// 异常没有处理, catch用于处理异常
			// 但是要关闭资源

		}
	}
}
