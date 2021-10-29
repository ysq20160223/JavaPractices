package interview.multi_thread_download;

import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

import utils.XLog;

/*
	1, 获取要下载的文件的长度
	2, 在本地建立与服务器相同文件名和长度的文件
	3, 计算每条线程需要下载的起点和终点
	4, 定义下载线程
		4-1, 构造函数传入id/起点/终点
		4-2, 拼接需要下载的请求参数
		4-3, 设置 RandAccesFile 的开始位置
	
*/

public class MulThreadDownload01 {

	private static int mThreadCount = 3;
	private static String mUrl = "http://localhost:8080/Web/video/FanQing.mkv";

	public static void main(String[] args) throws Exception {
		URL url = new URL(mUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		// 1
		int contentLength = conn.getContentLength();
		XLog.init().debug("contentLength: " + contentLength);
		if (-1 == contentLength) {
			XLog.init().debug("contentLeng == -1");
			return;
		}

		// 2
		RandomAccessFile raf = new RandomAccessFile(new File(mUrl).getName(), "rw");
		raf.setLength(contentLength);
		raf.close();
		// Logcat.init().debug("length: " + raf.length());

		// 3
		int blockSize = contentLength / mThreadCount;
		for (int id = 0; id < mThreadCount; id++) {
			int start = id * blockSize;
			int end = (id + 1) * blockSize - 1;

			if (id == mThreadCount - 1) {
				end = contentLength - 1;
			}

			// Logcat.init().debug("-id: " + id + ", start: " + start + ", end:
			// " + end);

			new Thread(new DownloadRunnable(id, start, end)).start();
		}

	}

	// 4
	private static class DownloadRunnable implements Runnable {

		private int mId;
		private int mStart;
		private int mEnd;

		// 4-1
		public DownloadRunnable(int id, int start, int end) {
			mId = id;
			mStart = start;
			mEnd = end;
		}

		@Override
		public void run() {
			XLog.init().debug("id: " + mId + ", start: " + mStart + ", end: " + mEnd);

			try {

				URL url = new URL(mUrl);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();

				// 4-2
				conn.setRequestProperty("range", "bytes=" + mStart + "-" + mEnd);

				// 4-3
				RandomAccessFile raf = new RandomAccessFile(new File(mUrl).getName(), "rw");
				raf.seek(mStart);

				InputStream in = conn.getInputStream(); // 必须在setRequestProperty之后

				if (206 == conn.getResponseCode()) {
					int len = 0;
					byte[] buf = new byte[128];
					while ((len = in.read(buf)) > 0) {
						raf.write(buf, 0, len);
					}
					in.close();
					raf.close();

					XLog.init().debug("id: " + mId + " Downloaded Completed");
				}

			} catch (Exception e) {
				XLog.init().debug(e.toString());
			}
		}
	}

}
