package bh.day_18.t07;

import java.util.Date;

import utils.FileUtils;
import utils.XLog;

/*
 * 用字符流向文件中写入数据
 */
public class Day1807 {

	public static void main(String[] args) {

		// FileWriter(String fileName)
		// 根据给定的文件名构造一个 FileWriter 对象。

		// FileWriter(String fileName, boolean append)
		// 根据给定的文件名以及指示是否附加写入数据的 boolean 值来构造 FileWriter 对象。

		FileUtils.fileWriter("Temp/day1807/NewFile.temp.txt", new Date() + "\r\nThis is new file\r\n\r\n");

		XLog.init().debug("over");
	}

}
