package bh.day_23.t08;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 * 需求：定义一个应用程序，用于接收 udp 协议传输的数据并处理
 * 1，定义 udp socket 服务，通常会监听一个端口，其实就是给这个接收网络应用程序定义数字标识，
 * 方便与明确哪些数据过来该应用程序可以处理
 * 
 * 2，定义一个数据包，因为要存储接收到的字节数据数据包对象中有更多功能可以提取字节数据中的不同数据信息
 * 
 * 3，通过socket服务的receive方法将收到的数据存入已定义好的数据包中
 * 
 * 4，通过数据包对象的特有功能，将这些不同的数据取出，打印出来
 * 
 * 5，关闭资源
 */
public class Day2308_01 {

	public static void main(String[] args) throws Exception {
		// 1
		DatagramSocket ds = new DatagramSocket(9999);// 监听端口
		// 2
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		// 3
		ds.receive(dp);
		// 4
		String ip = dp.getAddress().getHostAddress();
		String data = new String(dp.getData(), 0, dp.getLength());
		int port = dp.getPort();

		System.out.println("Send ip : " + ip);
		System.out.println("Send data : " + data);
		System.out.println("Send port : " + port);
		// 5
		ds.close();

	}

}
