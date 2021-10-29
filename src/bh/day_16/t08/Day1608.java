package bh.day_16.t08;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import utils.XLog;

/*
 * 需求 : 计算字符串中字母出现的次数
 * 
 * 1, 将字符串转换为字符数组
 * 2, 定义map集合, 有序选择TreeMap
 * 3, 遍历字符数组
 * 		3-1, 将每一个字符作为键去查map集合
 * 		3-2, 如果返回null, 将该字母和1存入到map集合中
 * 		3-3, 如果返回不是null, 说明该字母在map集合已经存在并有对应次数
 * 		3-4, 那么就获取该次数进行自增, 存储该字母和自增后的次数
 * 
 * 4, 将map集合中数据变成指定的字符串形式返回
 */
public class Day1608 {
	public static void main(String[] args) {
		String s = "abcaba55";
		XLog.init().debug(s + " : " + count(s));
	}

	public static String count(String s) {
		char[] chs = s.toCharArray();

		Map<Character, Integer> map = new TreeMap<Character, Integer>();

		for (int i = 0, count = 0; i < chs.length; count = 0, i++) {
			if (!('A' <= chs[i] && chs[i] <= 'Z' || 'a' <= chs[i] && chs[i] <= 'z')) {
				continue;
			}

			Integer value = map.get(chs[i]);
			if (null != value) {
				count = value;
			}
			map.put(chs[i], ++count);
		}

		StringBuilder sb = new StringBuilder();

		for (Iterator<Character> it = map.keySet().iterator(); it.hasNext();) {
			Character c = it.next();
			Integer value = map.get(c);
			sb.append(c).append("(").append(value).append(")");
		}

		return sb.toString();
	}
}
