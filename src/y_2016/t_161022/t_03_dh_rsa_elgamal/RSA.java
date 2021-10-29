package y_2016.t_161022.t_03_dh_rsa_elgamal;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

import utils.XLog;

public class RSA {

	private static String src = "Secure";

	public static void main(String[] args) throws Exception {
		jdkRSA();
	}

	public static void jdkRSA() throws Exception {
		// 1,初始化秘钥
		KeyPairGenerator keyPairGene = KeyPairGenerator.getInstance("RSA");
		keyPairGene.initialize(512);

		KeyPair keyPair = keyPairGene.generateKeyPair();
		RSAPublicKey rsaPubKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey rsaPriKey = (RSAPrivateKey) keyPair.getPrivate();

		XLog.init().debug("pub key : " + Base64.encodeBase64String(rsaPubKey.getEncoded()));
		XLog.init().debug("pri key : " + Base64.encodeBase64String(rsaPriKey.getEncoded()));

		// 2 - 私钥加密，公钥解密 - 加密
		PKCS8EncodedKeySpec pkcs8EnKeySpec = new PKCS8EncodedKeySpec(rsaPriKey.getEncoded());
		KeyFactory keyFac = KeyFactory.getInstance("RSA");
		PrivateKey priKey = keyFac.generatePrivate(pkcs8EnKeySpec);

		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, priKey);
		byte[] result = cipher.doFinal(src.getBytes());
		XLog.init().debug("私钥加密，公钥解密 - 加密 ： " + Base64.encodeBase64String(result));

		// 3 - 私钥加密，公钥解密 - 解密
		X509EncodedKeySpec x509EnKeySpec = new X509EncodedKeySpec(rsaPubKey.getEncoded());
		keyFac = KeyFactory.getInstance("RSA");
		PublicKey pubKey = keyFac.generatePublic(x509EnKeySpec);
		cipher.init(Cipher.DECRYPT_MODE, pubKey);
		result = cipher.doFinal(result);
		XLog.init().debug("私钥加密，公钥解密 - 解密 ： " + new String(result));

		// 4 - 公钥加密，私钥解密 - 加密
		x509EnKeySpec = new X509EncodedKeySpec(rsaPubKey.getEncoded());
		keyFac = KeyFactory.getInstance("RSA");
		pubKey = keyFac.generatePublic(x509EnKeySpec);
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		result = cipher.doFinal(src.getBytes());
		XLog.init().debug("公钥加密，私钥解密 - 加密 ： " + Base64.encodeBase64String(result));

		// 5 - 公钥加密，私钥解密 - 解密
		pkcs8EnKeySpec = new PKCS8EncodedKeySpec(rsaPriKey.getEncoded());
		keyFac = KeyFactory.getInstance("RSA");
		priKey = keyFac.generatePrivate(pkcs8EnKeySpec);

		cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, priKey);
		result = cipher.doFinal(result);
		XLog.init().debug("公钥加密，私钥解密 - 解密 ： " + new String(result));
	}

}
