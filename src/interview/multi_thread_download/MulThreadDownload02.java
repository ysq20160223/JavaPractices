package interview.multi_thread_download;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

import utils.XLog;

/*
	实现多线程断点下载
*/
public class MulThreadDownload02 {

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

		private int mCurPos; // 当前线程下载的位置

		// 5-1
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

				RandomAccessFile raf = new RandomAccessFile(new File(mUrl).getName(), "rw");

				File file = new File(mId + ".txt");
				if (file.exists() && file.length() > 0) {
					BufferedReader reader = new BufferedReader(new FileReader(file));

					int alreadyPos = Integer.valueOf(reader.readLine());
					reader.close();

					conn.setRequestProperty("range", "bytes=" + alreadyPos + "-" + mEnd);
					raf.seek(alreadyPos);

					XLog.init().debug("id: " + mId + ", alreadyPos: " + alreadyPos);
				} else {
					conn.setRequestProperty("range", "bytes=" + mStart + "-" + mEnd);
					raf.seek(mStart);
				}

				InputStream in = conn.getInputStream();

				if (206 == conn.getResponseCode()) {
					int len = 0;
					byte[] buf = new byte[1024 * 256];
					while ((len = in.read(buf)) > 0) {
						raf.write(buf, 0, len);

						mCurPos = mCurPos + len;

						// 没有实时写入
						OutputStream out = new FileOutputStream(file);
						out.write(String.valueOf(mCurPos).getBytes());
						out.close();

						// 实时写入 - 验证无效
						// RandomAccessFile out = new RandomAccessFile(file,
						// "rwd");
						// out.write(String.valueOf(mCurPos).getBytes());
						// out.close();

						XLog.init().debug("id: " + mId + ", curPos: " + mCurPos);
					}
					in.close();
					raf.close();

					XLog.init().debug("id: " + mId + " Download Completed, " + file.delete());
				}

			} catch (Exception e) {
				XLog.init().debug(e.toString());
			}
		}
	}

}
