package utils;

public class ThreadUtil {

	public static void sleep(long millis, String msg) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
			XLog.init().debug(msg + ": " + e);
		}
	}

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
			XLog.init().debug(e.toString());
		}
	}

	//

	public static void wait(Object syncObj, String msg) {
		try {
			syncObj.wait();
		} catch (Exception e) {
			XLog.init().debug(msg + ": " + e);
		}
	}

	public static void wait(Object syncObj) {
		try {
			syncObj.wait();
		} catch (Exception e) {
			XLog.init().debug(e.toString());
		}
	}

}
