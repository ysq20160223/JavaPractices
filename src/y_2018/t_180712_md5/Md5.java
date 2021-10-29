package y_2018.t_180712_md5;

import java.io.File;
import java.io.FileOutputStream;

import utils.XLog;

/**
 * 生成 MD5
 * 
 * @author root
 *
 */
public class Md5 {

	private static StringBuilder mStringBuilder = new StringBuilder();

	private static String iflyDir = "G:/AutoCopy/iflytek";
	private static String mxDir = "G:/AutoCopy/MXNavi";

	private static int mCount;

	public static void main(String[] args) throws Exception {

		// geneMd5(iflyDir);
		geneMd5(mxDir);

	}

	private static void geneMd5(String dir) throws Exception {
		mCount = 0;

		getMD5(dir, dir.substring(0, dir.lastIndexOf("/")));

		File md5File = new File(dir + File.separator + "check_sum.md5");
		XLog.init().debug("md5File: " + md5File);

		if (md5File.exists()) {
			md5File.delete();
		}
		md5File.createNewFile();

		FileOutputStream outputStream = new FileOutputStream(md5File);
		outputStream.write(mStringBuilder.toString().getBytes());
		outputStream.close();

	}

	/**
	 * 
	 * @param path
	 *            PC路径
	 * @param replace
	 *            替换
	 * @return
	 */
	private static void getMD5(String path, String replace) {
		File srcFile = new File(path);
		if (!srcFile.exists()) {
			XLog.init().debug("not exists: " + srcFile);
			return;
		}

		if (srcFile.isDirectory()) {
			// Logcat.init().debug("");
			// Logcat.init().debug("isDir: " + srcFile);
			File[] files = srcFile.listFiles();
			for (File file : files) {
				if (file.getAbsolutePath().contains("check_sum.md5")) {
					continue;
				}
				getMD5(file.getAbsolutePath(), replace);
			}
		} else {
			String md5 = Digest.getFileMd5(srcFile) + ",." + path.replaceAll("\\\\", "/").replaceAll(replace, "");
			XLog.init().debug(++mCount + ", " + md5);
			mStringBuilder.append(md5).append("\n");
		}
	}

}
