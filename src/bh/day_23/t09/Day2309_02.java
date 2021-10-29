package bh.day_23.t09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Day2309_02 {

	public static void main(String[] args) throws Exception {
		// 1
		DatagramSocket ds = new DatagramSocket(8888);

		// 2
		// byte[] buf = "Keyboard Input".getBytes();
		// DatagramPacket dp = new DatagramPacket(buf, buf.length,
		// InetAddress.getByName("192.168.1.148"), 9999);

		//
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while ((line = bufr.readLine()) != null) {
			if ("over".equals(line))
				break;
			byte[] buf = line.getBytes();
			DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("localHost"), 9999);
			// 3
			ds.send(dp);
			// if("over".equals(line))
			// break;
		}
		//
		// 3
		// ds.send(dp);
		// 4
		ds.close();
	}

}
