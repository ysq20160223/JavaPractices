package y_2016.t_161022.t_03_dh_rsa_elgamal;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Objects;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;

import utils.XLog;

public class DH {

	private static String src = "Secure";

	public static void main(String[] args) throws Exception {
		jdkDH();
	}

	public static void jdkDH() throws Exception {
		// 1,初始化发送发密钥
		KeyPairGenerator sendKeyPairGene = KeyPairGenerator.getInstance("DH");
		sendKeyPairGene.initialize(512);
		KeyPair sendKeyPair = sendKeyPairGene.genKeyPair();

		// 发送方公钥，发送给接收方（网络、文件）
		byte[] sendPubKeyEnc = sendKeyPair.getPublic().getEncoded();

		// 2,初始化接收方密钥
		KeyFactory receiKeyFac = KeyFactory.getInstance("DH");
		X509EncodedKeySpec x509EnKeySpec = new X509EncodedKeySpec(sendPubKeyEnc);
		PublicKey receiPubKey = receiKeyFac.generatePublic(x509EnKeySpec);
		DHParameterSpec dhParaSpec = ((DHPublicKey) receiPubKey).getParams();
		KeyPairGenerator receiKeyPairGene = KeyPairGenerator.getInstance("DH");
		receiKeyPairGene.initialize(dhParaSpec);
		KeyPair receiKeyPair = receiKeyPairGene.generateKeyPair();
		PrivateKey receiPriKey = receiKeyPair.getPrivate();
		byte[] receiPubKeyEnc = receiKeyPair.getPublic().getEncoded();

		// 3,密钥构建
		KeyAgreement receiKeyAgree = KeyAgreement.getInstance("DH");
		receiKeyAgree.init(receiPriKey);
		receiKeyAgree.doPhase(receiPubKey, true);
		SecretKey receiDesKey = receiKeyAgree.generateSecret("DES");

		KeyFactory sendKeyFac = KeyFactory.getInstance("DH");
		x509EnKeySpec = new X509EncodedKeySpec(receiPubKeyEnc);
		PublicKey sendPubKey = sendKeyFac.generatePublic(x509EnKeySpec);
		KeyAgreement sendKeyAgree = KeyAgreement.getInstance("DH");
		sendKeyAgree.init(sendKeyPair.getPrivate());
		sendKeyAgree.doPhase(sendPubKey, true);

		SecretKey sendDesKey = sendKeyAgree.generateSecret("DES");
		if (Objects.equals(receiDesKey, sendDesKey)) {
			XLog.init().debug("The same");
		}

		// 4,加密
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, sendDesKey);
		byte[] result = cipher.doFinal(src.getBytes());
		XLog.init().debug("jdk dh encrypt : " + org.apache.commons.codec.binary.Base64.encodeBase64String(result));

		// 5,解密
		cipher.init(Cipher.DECRYPT_MODE, receiDesKey);
		result = cipher.doFinal(result);
		XLog.init().debug("jdk dh decrypt : " + new String(result));
	}
}
