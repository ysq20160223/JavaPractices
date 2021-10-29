package bh.day_19.t21;

import java.io.File;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import utils.XLog;

public class Day1921 {

	public static void main(String[] args) throws Exception {
		try {
			int[] array = new int[2];
			array[3] = 0;
		} catch (Exception e) {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String s = sdf.format(date);

			File file = new File("Temp/day1921");
			if (!file.exists()) {
				file.mkdirs();
			}

			PrintStream ps = new PrintStream(file + "/PrintException.temp.txt");
			ps.println(s);
			System.setOut(ps);
			e.printStackTrace(System.out);
		}

		XLog.init().debug("over");
	}

}
