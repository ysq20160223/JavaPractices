package bh.day_20.t17;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import utils.XLog;

public class Day2017 {

	private static int count;

	private static String dir = "Temp\\day2017\\";

	public static void main(String[] args) throws Exception {
		splitFile(); // 分割文件
		mergeFile(); // 合并文件
	}

	public static void mergeFile() throws Exception {

		List<FileInputStream> al = new ArrayList<FileInputStream>();

		for (int i = 0; i < count; i++) {
			if (i < 10) {
				al.add(new FileInputStream(dir + "split0" + i + ".temp"));
			} else {
				al.add(new FileInputStream(dir + "split" + i + ".temp"));
			}
		}
		/**/
		final Iterator<FileInputStream> it = al.iterator();

		Enumeration<InputStream> e = new Enumeration<InputStream>() {

			@Override
			public boolean hasMoreElements() {
				return it.hasNext();
			}

			@Override
			public FileInputStream nextElement() {
				return it.next();
			}
		};
		SequenceInputStream sis = new SequenceInputStream(e);
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dir + "color_merge.temp.png"));
		byte[] buf = new byte[2048];
		int len = 0;
		while ((len = sis.read(buf)) != -1) {
			bos.write(buf, 0, len);
		}
		sis.close();
		bos.close();
		XLog.init().debug("merge over");
	}

	public static void splitFile() throws Exception {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("color.png"));
		BufferedOutputStream bos = null;

		File file = new File(dir);
		if (!file.exists()) {
			file.mkdirs();
		}

		int len = 0;
		byte[] buf = new byte[2048];

		while ((len = bis.read(buf)) != -1) {
			if (count < 10) {
				bos = new BufferedOutputStream(new FileOutputStream(dir + "split0" + count++ + ".temp"));
			} else {
				bos = new BufferedOutputStream(new FileOutputStream(dir + "split" + count++ + ".temp"));
			}

			bos.write(buf, 0, len);
			bos.close();
		}
		if (bos != null)
			bos.close();
		bis.close();
		XLog.init().debug("split over");
	}

}
