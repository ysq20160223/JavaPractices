package y_2021.t_211029;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import utils.XLog;

public class Agency {

	@SuppressWarnings("unchecked")
	public <T> T create(final Class<T> service) {
		T t = (T) Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[] { service }, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
				if (method.getDeclaringClass() == Object.class) {
					XLog.init().debug("invoke; name: " + method.getName() + "; " + Util.time());
					return method.invoke(this, args);
				}

				Response res = new Response();
				XLog.init().debug("invoke; res: " + res + "; name: " + method.getName() + "; " + Util.time());

				return res;
			}
		});
		XLog.init().debug("create; t: " + t + "; " + Util.time()); //
		return t;
	}

}
