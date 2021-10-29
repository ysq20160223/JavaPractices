package y_2016.t_161022.t_05_rsa_dsa_ecdsa;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Hex;

import utils.XLog;

public class ECDSA {

	private static String src = "Secure";

	public static void main(String[] args) throws Exception {
		jdkECDSA();
	}

	// java的 jdk 里面相关方法实现ECDSA的签名及签名验证,要jdk7.x以上，ECDSA：椭圆曲线数字签名算法
	public static void jdkECDSA() throws Exception {
		// 1.初始化密钥
		KeyPairGenerator keyPairGene = KeyPairGenerator.getInstance("EC");
		keyPairGene.initialize(256);
		KeyPair keyPair = keyPairGene.generateKeyPair();
		ECPublicKey ecPubKey = (ECPublicKey) keyPair.getPublic();
		ECPrivateKey ecPriKey = (ECPrivateKey) keyPair.getPrivate();

		// 2.进行签名
		PKCS8EncodedKeySpec pkcs8EnKeySpec = new PKCS8EncodedKeySpec(ecPriKey.getEncoded());
		KeyFactory keyFac = KeyFactory.getInstance("EC");
		PrivateKey priKey = keyFac.generatePrivate(pkcs8EnKeySpec);
		Signature signature = Signature.getInstance("SHA1withECDSA");
		signature.initSign(priKey);
		signature.update(src.getBytes());
		byte[] result = signature.sign();
		XLog.init().debug("jdk ecdsa sign : " + Hex.encodeHexString(result));

		// 3.验证签名
		X509EncodedKeySpec x509EnKeySpec = new X509EncodedKeySpec(ecPubKey.getEncoded());
		keyFac = KeyFactory.getInstance("EC");
		PublicKey pubKey = keyFac.generatePublic(x509EnKeySpec);
		signature = Signature.getInstance("SHA1withECDSA");
		signature.initVerify(pubKey);
		signature.update(src.getBytes());
		boolean bool = signature.verify(result);
		XLog.init().debug("jdk ecdsa verify : " + bool);

	}

}
