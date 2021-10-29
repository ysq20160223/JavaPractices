package bh.day_23.t08;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Day2308_02 {

	public static void main(String[] args) throws Exception {
		// 1

		// 发送端如果没有定义端口，则系统会默认指定端口
		DatagramSocket ds = new DatagramSocket(8888);

		// 2
		byte[] buf = "Hello Receive Port. This is Send Port".getBytes();
		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("localHost"), 9999);
		// 3
		ds.send(dp);
		// 4
		ds.close();
	}

}
