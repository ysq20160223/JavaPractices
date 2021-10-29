package y_2021.t_211029;

import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Modifier;

import sun.misc.ProxyGenerator;
import utils.XLog;

/*
 	动态代理
 	
 */

@SuppressWarnings("unused")
public class DynamicProxy {

	public static void main(String[] args) throws Exception {
		testAgent();

		// generateProxyClass();
	}

	@SuppressWarnings("resource")
	private static void generateProxyClass() throws Exception {
		byte[] proxyClassFile = ProxyGenerator.generateProxyClass("ProxyTemp", new Class[] { Api.class },
				Modifier.FINAL | Modifier.PUBLIC);

		new RandomAccessFile(new File("ProxyTemp.class"), "rw").write(proxyClassFile);

		XLog.init().debug("over");
	}

	private static void testAgent() throws Exception {
		Agency agency = new Agency();

		XLog.init().debug("main -> " + Util.time());
		Api api = agency.create(Api.class);
		XLog.init().debug("main -> api: " + api + "; " + Util.time());

		Thread.sleep(2000);

		api.def();

		// Response response = api.login("loginName", "pwd");
		// XLog.init().debug("main -> response: " + response + "; " +
		// Util.time());
	}

}
