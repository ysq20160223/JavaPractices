package y_2016.t_161022.t_04_md_sha_hmac;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.digests.MD2Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import utils.XLog;

public class MD {

	private static String src = "Secure";

	public static void main(String[] args) throws Exception {
		jdkMD5();
		jdkMD2();

		System.out.println();

		bcMD4();
		bcMD5();
		bcMD2();

		System.out.println();

		ccMD5();
		ccMD2();

		// jdk MD5 : 7a2ccf251ecb20b2b84ce0e3c3f72a29
		// jdk MD2 : eb98db4cfa05fe9fca98ad37ca0f6583
		//
		// bc MD4 : fbeaed35c956d9ceeeaa1f17e6df7557
		// bc MD5 : 7a2ccf251ecb20b2b84ce0e3c3f72a29
		// bc MD2 : eb98db4cfa05fe9fca98ad37ca0f6583
		//
		// cc MD5 : 7a2ccf251ecb20b2b84ce0e3c3f72a29
		// cc MD2 : eb98db4cfa05fe9fca98ad37ca0f6583
	}

	// MD
	public static void jdkMD5() throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] md5 = md.digest(src.getBytes());
		XLog.init().debug("jdk MD5 : " + Hex.encodeHexString(md5));
	}

	public static void jdkMD2() throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD2");
		byte[] md2 = md.digest(src.getBytes());
		XLog.init().debug("jdk MD2 : " + Hex.encodeHexString(md2));
	}

	// BC
	public static void bcMD4() throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		MessageDigest md = MessageDigest.getInstance("MD4");
		byte[] md4 = md.digest(src.getBytes());
		XLog.init().debug("bc MD4 : " + Hex.encodeHexString(md4));
	}

	public static void bcMD5() {
		MD5Digest md5Digest = new MD5Digest();
		md5Digest.update(src.getBytes(), 0, src.getBytes().length);
		byte[] md5 = new byte[md5Digest.getDigestSize()];
		md5Digest.doFinal(md5, 0);
		XLog.init().debug("bc MD5 : " + org.bouncycastle.util.encoders.Hex.toHexString(md5));
	}

	public static void bcMD2() {
		MD2Digest md2Digest = new MD2Digest();
		md2Digest.update(src.getBytes(), 0, src.getBytes().length);
		byte[] md2 = new byte[md2Digest.getDigestSize()];
		md2Digest.doFinal(md2, 0);
		XLog.init().debug("bc MD2 : " + org.bouncycastle.util.encoders.Hex.toHexString(md2));
	}

	// CC
	public static void ccMD5() {
		XLog.init().debug("cc MD5 : " + DigestUtils.md5Hex(src.getBytes()));
	}

	public static void ccMD2() {
		XLog.init().debug("cc MD2 : " + DigestUtils.md2Hex(src.getBytes()));
	}
}
