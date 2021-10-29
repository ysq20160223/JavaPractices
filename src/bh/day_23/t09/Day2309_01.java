package bh.day_23.t09;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 * 发送端从键盘录入，并发送给接收端
 */

public class Day2309_01 {

	public static void main(String[] args) throws Exception {
		// 1
		@SuppressWarnings("resource")
		DatagramSocket ds = new DatagramSocket(9999);

		while (true) {
			// 2
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			// 3
			ds.receive(dp);
			// 4
			String ip = dp.getAddress().getHostAddress();
			String data = new String(dp.getData(), 0, dp.getLength());

			System.out.println("Send ip : " + ip);
			System.out.println("Send data : " + data);
		}
		// 5
		// ds.close();
	}

}
