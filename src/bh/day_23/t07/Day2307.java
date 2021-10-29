package bh.day_23.t07;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * 发送端：没定义接收端，发送数据后没有被接收
 * 
 * 需求：
 * 
 * 1，建立udpsocket服务
 * DatagramSocket() 
 * 		构造数据报套接字并将其绑定到本地主机上任何可用的端口。
 * DatagramSocket(int port) 
 * 		创建数据报套接字并将其绑定到本地主机上的指定端口。
 * 
 * 2，提供数据，并将数据封装到数据包中
 * DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
 * 		构造数据报包，用来将长度为 length 的包发送到指定主机上的指定端口号。
 * 
 * 3，通过socket服务的发送功能，将数据发送出去
 * 4，关闭资源
 */
public class Day2307 {

	public static void main(String[] args) throws Exception {
		// 1, 创建udp服务，通过DatagramSocket对象
		DatagramSocket ds = new DatagramSocket(8888);

		// 2, 确定数据，并封装成数据包
		byte[] buf = "udp send data".getBytes();
		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("localHost"), 9999);

		// 3, 通过socket服务，将已有的数据包发送出去，通过send方法
		ds.send(dp);
		// 4, 关闭资源
		ds.close();
	}

}
