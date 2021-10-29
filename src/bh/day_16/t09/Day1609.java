package bh.day_16.t09;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import utils.XLog;

/*
	senior
		senior01, 10
		senior02, 20
		
	junior
		junior01, 30
		junior02, 40
 */
public class Day1609 {

	public static void main(String[] args) {

		Map<String, Map<String, String>> map = new HashMap<>();

		Map<String, String> seniorMap = new HashMap<>();
		seniorMap.put("s01", "1");
		seniorMap.put("s02", "2");

		Map<String, String> juniorMap = new HashMap<>();
		juniorMap.put("j03", "3");
		juniorMap.put("j04", "4");

		map.put("senior", seniorMap);
		map.put("junior", juniorMap);

		// keySet
		XLog.init().debug("*** keySet ***");
		for (Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
			String key = it.next();
			Map<String, String> value = map.get(key);

			XLog.init().debug("key: " + key);

			entrySet(value);

			XLog.init().debug(null);
		}

		// entrySet
		XLog.init().debug("*** entrySet ***");
		for (Iterator<Map.Entry<String, Map<String, String>>> it = map.entrySet().iterator(); it.hasNext();) {
			Map.Entry<String, Map<String, String>> entry = it.next();

			XLog.init().debug("key: " + entry.getKey());

			entrySet(entry.getValue());

			XLog.init().debug(null);

		}
	}

	public static void entrySet(Map<String, String> map) {
		Set<Map.Entry<String, String>> set = map.entrySet();
		for (Iterator<Map.Entry<String, String>> ite = set.iterator(); ite.hasNext();) {
			Map.Entry<String, String> entry = ite.next();
			String key = entry.getKey();
			String value = entry.getValue();
			XLog.init().debug("key: " + key + ", value: " + value);
		}
	}

}

class Student implements Comparable<Student> {
	public String name;
	public int age;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Student s) {
		int flag = new Integer(age).compareTo(new Integer(s.age));
		XLog.init().debug("compareTo: " + age + " : " + s.age + " -- " + flag);
		return flag;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String toString() {
		return "[Name: " + name + ", Age: " + age + "]";
	}
}
