package bh.day_20.t16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.SequenceInputStream;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

import utils.FileUtils;
import utils.XLog;

public class Day2016 {

	public static void main(String[] args) throws Exception {
		File fileA = new File("Temp\\day2016\\a.temp.txt");
		File fileB = new File("Temp\\day2016\\b.temp.txt");
		FileUtils.bufferedWriter(fileA.getAbsolutePath(), new Date() + "AAA");
		FileUtils.bufferedWriter(fileB.getAbsolutePath(), new Date() + "bbb");

		Vector<FileInputStream> v = new Vector<>();
		v.add(new FileInputStream(fileA));
		v.add(new FileInputStream(fileB));

		Enumeration<FileInputStream> e = v.elements();

		SequenceInputStream sis = new SequenceInputStream(e);

		BufferedReader br = new BufferedReader(new InputStreamReader(sis));

		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream("Temp\\day2016\\add_a_b.temp.txt")));

		// for(String len = null; (len = br.readLine()) != null;){
		// System.out.println(len.toUpperCase());
		// bw.write(len);
		// bw.newLine();
		// }

		int len = 0;
		char[] buf = new char[1024];
		while ((len = br.read(buf)) != -1) {
			XLog.init().debug(new String(buf, 0, len).toUpperCase());
			bw.write(buf, 0, len);
			bw.newLine();
		}
		bw.close();
		br.close();

	}

}
