package y_2018.t_180712_reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import utils.XLog;

/*
 * Class.forName("包名.类名")
 * 
 * 编译时刻加载类: 静态类
 * 运行时刻加载类: 动态类
 * 
 * 
 * new 创建对象 是 静态加载类, 在编译时刻就需要加载所有可能用到的类
 * 
 *
 */
@SuppressWarnings("unused")
public class TestReflect {

	public static void main(String[] args) throws Exception {

		// testField();

		testMethod();

		// testConstructor();
	}

	/*
	 * 获取构造函数
	 */
	private static void testConstructor() throws Exception {
		Class clazz = Class.forName("t_2018.t_180712_reflect.Person");

		Constructor con = clazz.getDeclaredConstructor(int.class, String.class);
		con.setAccessible(true);
		XLog.init().debug(con.newInstance(21, "yy"));

		Constructor[] cons = clazz.getDeclaredConstructors();
		for (int i = 0; i < cons.length; i++) {
			cons[i].setAccessible(true);

			XLog.init().debug("con[" + i + "]: " + cons[i]);
		}
	}

	/*
	 * 获取方法
	 */
	private static void testMethod() throws Exception {
		Method[] methods = Person.class.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			methods[i].setAccessible(true);

			StringBuilder sb = new StringBuilder();
			sb.append(i).append(": ");
			sb.append(methods[i].getReturnType().getSimpleName()); // 返回值类型
			sb.append(" ").append(methods[i].getName()).append("("); // 方法名

			Class[] paraType = methods[i].getParameterTypes();
			for (int j = 0; j < paraType.length; j++) {
				sb.append(paraType[j].getSimpleName()); // 参数名
				if (j < paraType.length - 1) {
					sb.append(", ");
				}
			}
			sb.append(")");

			XLog.init().debug(sb);

			// if ("print".equals(methods[i].getName())) {
			// methods[i].invoke(new Person("yy"));
			// }
		}
	}

	/*
	 * 获取属性
	 */
	private static void testField() {
		Field[] fields = Person.class.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);

			StringBuilder sb = new StringBuilder();
			sb.append(i).append(": ");
			sb.append(fields[i].getType().getSimpleName()); // 获取修饰类型
			sb.append(" ").append(fields[i].getName()); // 获取属性

			XLog.init().debug(sb);
		}
	}

}
