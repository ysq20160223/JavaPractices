package bh.day_18.t01;

import java.util.Properties;

import utils.XLog;

/*
	简介：
		描述系统的一些信息
	
	获取系统属性的信息：Properties getProperties();
	
	因为Properties是HashTable的子类，也就是Map集合的一个子类对象，那么可以通过map的方法取出该集合中的元素
	
	类中的方法和属性都是静态的
		
	out：标准输出，默认是控制台
	in：标准输入，默认是键盘
 */
public class Day1801 {
	public static void main(String[] args) {
		Properties properties = System.getProperties();

		for (Object object : properties.keySet()) {
			String string = (String) object;
			XLog.init().debug(string + " = " + properties.getProperty(string));
		}
	}
}
