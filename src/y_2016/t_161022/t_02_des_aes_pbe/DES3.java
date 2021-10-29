package y_2016.t_161022.t_02_des_aes_pbe;

import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import utils.XLog;

public class DES3 {

	private static String src = "Secure";

	public static void main(String[] args) throws Exception {
		jdk3DES();

		bc3DES();
	}

	public static void jdk3DES() throws Exception {
		// 生成 key
		KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");

		// keyGenerator.init(168);
		keyGenerator.init(new SecureRandom());

		SecretKey secretKey = keyGenerator.generateKey();
		byte[] byteKey = secretKey.getEncoded();

		// key 转换
		DESedeKeySpec desKeySpec = new DESedeKeySpec(byteKey);
		SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
		SecretKey convertSecretKey = factory.generateSecret(desKeySpec);

		// 加密
		Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
		byte[] result = cipher.doFinal(src.getBytes());
		XLog.init().debug("jdk 3des encrypt : " + Hex.encodeHexString(result));

		// 解密
		cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
		result = cipher.doFinal(result);
		XLog.init().debug("jdk 3des decrypt : " + new String(result));
	}

	public static void bc3DES() throws Exception {
		Security.addProvider(new BouncyCastleProvider());

		// 生成 key
		KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede", "BC");
		keyGenerator.init(192);
		SecretKey secretKey = keyGenerator.generateKey();
		byte[] byteKey = secretKey.getEncoded();

		// key 转换
		DESedeKeySpec desKeySpec = new DESedeKeySpec(byteKey);
		SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
		SecretKey convertSecretKey = factory.generateSecret(desKeySpec);

		// 加密
		Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
		byte[] result = cipher.doFinal(src.getBytes());
		XLog.init().debug("bc 3des encrypt : " + Hex.encodeHexString(result));

		// 解密
		cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
		result = cipher.doFinal(result);
		XLog.init().debug("bc 3des decrypt : " + new String(result));
	}

}
