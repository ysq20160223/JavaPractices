package bh.day_23.t10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Day2310_02 {

	public static void main(String[] args) throws Exception {
		// 1
		DatagramSocket ds = new DatagramSocket(8888);
		// 2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while ((line = br.readLine()) != null) {
			if ("over".equals(line))
				break;
			byte[] buf = line.getBytes();
			DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("localHost"), 9999);
			// 3
			ds.send(dp);
		}
		// 4
		ds.close();
	}

}
