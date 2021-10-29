package y_2021.t_211029;

import utils.XLog;

public interface Api {

	Response login(String loginName, String pwd);

	default void def() {
		XLog.init().debug("Api -> def");
	}

}
