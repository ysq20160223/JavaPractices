package y_2016.t_161022.t_02_des_aes_pbe;

import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import utils.XLog;

public class DES {

	private static String src = "Secure";

	public static void main(String[] args) throws Exception {
		jdkDES();

		bcDES();
	}

	public static void jdkDES() throws Exception {
		// 生成 key
		KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
		keyGenerator.init(56);
		SecretKey secretKey = keyGenerator.generateKey();
		byte[] byteKey = secretKey.getEncoded();

		// key 转换
		DESKeySpec desKeySpec = new DESKeySpec(byteKey);
		SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
		SecretKey convertSecretKey = factory.generateSecret(desKeySpec);

		// 加密
		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
		byte[] result = cipher.doFinal(src.getBytes());
		XLog.init().debug("jdk des encrypt : " + Hex.encodeHexString(result));

		// 解密
		cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
		result = cipher.doFinal(result);
		XLog.init().debug("jdk des decrypt : " + new String(result));
	}

	public static void bcDES() throws Exception {
		Security.addProvider(new BouncyCastleProvider());

		// 生成 key
		KeyGenerator keyGenerator = KeyGenerator.getInstance("DES", "BC");
		keyGenerator.init(56);
		SecretKey secretKey = keyGenerator.generateKey();
		byte[] byteKey = secretKey.getEncoded();

		// key 转换
		DESKeySpec desKeySpec = new DESKeySpec(byteKey);
		SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
		SecretKey convertSecretKey = factory.generateSecret(desKeySpec);

		// 加密
		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
		byte[] result = cipher.doFinal(src.getBytes());
		XLog.init().debug("bc des encrypt : " + Hex.encodeHexString(result));

		// 解密
		cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
		result = cipher.doFinal(result);
		XLog.init().debug("bc des decrypt : " + new String(result));
	}

}
