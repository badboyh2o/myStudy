package com.hqxu.codec;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;



/**
 * 1.
 * JAVA中，默认支持AES128，如果要使用AES256，还需要替换一下两个文件。local_policy.jar和US_export_policy.jar
 * 	%JRE_HOME%\lib\security
 * 	%JDK_HOME%\jre\lib\security
 * 
 * 
 * 2.AES/CTR/NoPadding
 * 	32B key
 *  IvParameter 16B
 * 
 * 
 * 
 */
public class AESUtil {

	public final static String IV_STRING = "1234567812345678"; //16
	public final static String DATA_ENCODE = "utf-8"; //
	

	// encryptAES
	public static byte[] encrypt(String data, String key) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, NoSuchProviderException{
		byte[] dataBytes = data.getBytes(DATA_ENCODE); // data byte
		byte[] keyBytes = key.getBytes();
		
		SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
		IvParameterSpec ivParameterSpec = new IvParameterSpec(IV_STRING.getBytes()); // IV
		
		Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec); //init
		byte[]enctyptBytes = cipher.doFinal(dataBytes);
		return enctyptBytes;
	}
	
	// decryptAES
	public static String decrypt(byte[] enctyptBytes, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, NoSuchProviderException{
		byte[] keyBytes = key.getBytes();
		
		SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
		IvParameterSpec ivParameterSpec = new IvParameterSpec(IV_STRING.getBytes()); // IV
		
		Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec); //init
		
		byte[] dataBytes = cipher.doFinal(enctyptBytes);
		return new String(dataBytes, DATA_ENCODE);
	}
	
}
