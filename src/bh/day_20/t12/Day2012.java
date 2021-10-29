package bh.day_20.t12;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import utils.XLog;

/*
 * public class Properties extends Hashtable<Object,Object>
 * Properties是HashTable的子类
 * 也就是说它是具备Map集合的特点，而且它里面存储的键值对都是字符串
 * 是集合和IO技术相结合的集合容器
 * 该对象的特点：可以用于键值对形式的配置文件	
 */
public class Day2012 {

	public static void main(String[] args) {
		Properties p = new Properties();

		for (int i = 0; i < 5; i++) {
			p.setProperty("k" + i, "v" + i);
		}

		XLog.init().debug("p: " + p);

		Set<String> names = p.stringPropertyNames();

		for (Iterator<String> it = names.iterator(); it.hasNext();) {
			String name = it.next();
			String value = p.getProperty(name);
			XLog.init().debug("Name:" + name + ", Value:" + value);
		}
	}

}
