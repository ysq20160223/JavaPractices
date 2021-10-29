package bh.day_21.t02;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import utils.XLog;

public class Day2102 {

	public static void main(String[] args) throws Exception {
		PipedInputStream pis = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream();
		pis.connect(pos);

		new Thread(new InputPipedStream(pis)).start();
		new Thread(new InputPipedStream(pis)).start();
		new Thread(new InputPipedStream(pis)).start();
		new Thread(new InputPipedStream(pis)).start();
		new Thread(new InputPipedStream(pis)).start();

		new Thread(new OutputPipedStream(pos)).start();
	}

}

class InputPipedStream implements Runnable {
	PipedInputStream pis;

	public InputPipedStream(PipedInputStream pis) {
		this.pis = pis;
	}

	@Override
	public void run() {
		try {
			byte[] buf = new byte[1024];
			int len = pis.read(buf); // 管道输入流读取管道中的数据
			XLog.init().debug(Thread.currentThread() + " - Input : Wait Input data");
			if (len > 0) {
				XLog.init().debug(Thread.currentThread() + " - " + new String(buf, 0, len));
			} else {
				XLog.init().debug(Thread.currentThread() + " - No data");
			}
		} catch (Exception e) {
			XLog.init().debug(e);
		}
	}
}

class OutputPipedStream implements Runnable {
	PipedOutputStream pos;

	public OutputPipedStream(PipedOutputStream pos) {
		this.pos = pos;
	}

	@Override
	public void run() {
		try {
			XLog.init().debug("Ready Output . . .");
			Thread.sleep(3000);
			XLog.init().debug("Start Output . . .");
			pos.write("This is piped data".getBytes()); // 管道输出流是管道的发送端
			// 数据由某个线程写入 PipedOutputStream 对象，并由其他线程从连接的 PipedInputStream 读取
			Thread.sleep(3000);
			XLog.init().debug("Output End");
			pos.close();
		} catch (Exception e) {
			XLog.init().debug(e);
		}
	}
}
