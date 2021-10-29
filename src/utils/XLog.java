package utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class XLog {

	static {
		PropertyConfigurator.configure("log4j.properties");
	}

	public static Logger init() {
		return Logger.getLogger(Object.class);
	}

}
