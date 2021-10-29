package y_2016.t_161022.t_04_md_sha_hmac;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

import utils.XLog;

public class HMAC {

	private static String src = "Secure";

	public static void main(String[] args) throws Exception {
		jdkHmacMD5();

		bcHmacMD5();
	}

	public static void jdkHmacMD5() throws Exception {
		// 1
		// KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
		// SecretKey secretKey = keyGenerator.generateKey();
		// byte[] key = secretKey.getEncoded();

		// 2
		byte[] key = Hex.decodeHex(new char[] { 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a' });
		//
		SecretKey restoreKey = new SecretKeySpec(key, "HmacMD5"); // 还原
		Mac mac = Mac.getInstance(restoreKey.getAlgorithm()); // 实例化

		// 初始化
		mac.init(restoreKey);
		byte[] hmacMD5 = mac.doFinal(src.getBytes());

		XLog.init().debug("jdk Hmac MD5 : " + Hex.encodeHexString(hmacMD5));
	}

	public static void bcHmacMD5() {
		HMac hMac = new HMac(new MD5Digest());
		hMac.init(new KeyParameter(org.bouncycastle.util.encoders.Hex.decode("aaaaaaaaaa")));
		hMac.update(src.getBytes(), 0, src.getBytes().length);

		byte[] hmacMd5 = new byte[hMac.getMacSize()];
		hMac.doFinal(hmacMd5, 0);

		XLog.init().debug("bc Hmac MD5 : " + org.bouncycastle.util.encoders.Hex.toHexString(hmacMd5));
	}

}
