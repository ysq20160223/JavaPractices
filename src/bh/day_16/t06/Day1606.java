package bh.day_16.t06;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import bh.day_16.Student;
import utils.XLog;;

/*
 * HashMap Comparable
 * 
 * 1, 描述学生
 * 2, 定义 map 容器, 将学生作为键, 地址作为值存入
 * 3, 获取 map 集合中的元素
 * 
 */
public class Day1606 {

	public static void main(String[] args) {

		Map<Student, String> map = new HashMap<Student, String>();

		map.put(new Student("hh", 17), "HH");
		XLog.init().debug(null);

		map.put(new Student("jj", 1), "JJ");
		XLog.init().debug(null);

		map.put(new Student("jj", 1), "JJJ"); // 需判断 key 是否相同, 若相同, 覆盖 value
		XLog.init().debug(null);

		map.put(new Student("yy", 21), "YY");
		XLog.init().debug(null);

		XLog.init().debug("*** keySet ***");
		Set<Student> keySet = map.keySet();
		for (Iterator<Student> it = keySet.iterator(); it.hasNext();) {
			Student s = it.next();
			XLog.init().debug(s + ", Address: " + map.get(s));
		}
	}
}
