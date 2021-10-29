package y_2018.t_180712_md5;

/*
    Created by y on 2017/11/7.

    消息摘要
        获取文件 MD5 值

 */

import java.io.File;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.security.MessageDigest;

import utils.XLog;

public class Digest {

	/**
	 * 获取文件 MD5 值
	 */
	public static String getFileMd5(File file) {
		if (null == file) {
			return null;
		}
		if (!file.exists()) {
			return null;
		}

		MessageDigest messageDigest;
		RandomAccessFile randomAccessFile = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			randomAccessFile = new RandomAccessFile(file, "r");
			byte[] bytes = new byte[1024 * 1024 * 10];
			int len;
			while ((len = randomAccessFile.read(bytes)) != -1) {
				messageDigest.update(bytes, 0, len);
			}
			BigInteger bigInt = new BigInteger(1, messageDigest.digest());
			String md5 = bigInt.toString(16);
			while (md5.length() < 32) {
				md5 = "0" + md5;
			}
			return md5;
		} catch (Exception e) {
			XLog.init().debug(e.toString());
		} finally {
			try {
				if (null != randomAccessFile) {
					randomAccessFile.close();
				}
			} catch (Exception e) {
				XLog.init().debug(e.toString());
			}
		}
		return null;
	}

}
