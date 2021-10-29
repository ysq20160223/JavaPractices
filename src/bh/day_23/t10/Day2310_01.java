package bh.day_23.t10;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Day2310_01 {

	public static void main(String[] args) throws Exception {
		// 1
		@SuppressWarnings("resource")
		DatagramSocket ds = new DatagramSocket(9999);
		// 2
		while (true) {
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			// 3
			ds.receive(dp);
			// 4
			String ip = dp.getAddress().getHostAddress();
			String data = new String(dp.getData(), 0, dp.getLength());

			System.out.println("IP : " + ip);
			System.out.println("data : " + data);
		}

		// 5
		// ds.close();
	}

}
