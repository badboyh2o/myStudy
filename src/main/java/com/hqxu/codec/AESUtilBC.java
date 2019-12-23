package com.hqxu.codec;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;  
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;  
  
import org.bouncycastle.jce.provider.BouncyCastleProvider;  


/**
 * bcprov.jar
 * 
 * 1.BouncyCastleProvider
 * 2.AES/CTR/NoPadding
 * 	create 32B key by password
 *  IvParameter 16B
 *
 */
public class AESUtilBC {

	public final static String IV_STRING = "1234567812345678"; //16
	public final static String DATA_ENCODE = "utf-8"; //
	
	static{
		if((Security.getProvider(BouncyCastleProvider.PROVIDER_NAME)) == null){
			Security.addProvider(new BouncyCastleProvider());
		}
	}
	
    public static byte[] encrypt(String content, String password) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {  
        // key
    	byte[] secretKeyBytes = getSecretKey(password);
        
        // SecretKeySpec IvParameterSpec
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKeyBytes, "AES");  
		IvParameterSpec ivParameterSpec = new IvParameterSpec(IV_STRING.getBytes()); // IV
		
		// BouncyCastleProvider
        //Security.addProvider(new BouncyCastleProvider());  
        
        Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding", BouncyCastleProvider.PROVIDER_NAME); 
        
        //  javax.crypto.Cipher.init(int opmode, Key key, AlgorithmParameterSpec params)
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);  
        
        byte[] contentBytes = content.getBytes(DATA_ENCODE);  
        byte[] encryptBytes = cipher.doFinal(contentBytes);
        
        return encryptBytes;
    }

	private static byte[] getSecretKey(String password) throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");  
        //securerandom：密钥生成器的随机源  
        SecureRandom securerandom = new SecureRandom(tohash256Deal(password));  
        keyGenerator.init(256, securerandom);  
        SecretKey secretKey = keyGenerator.generateKey();  
        byte[] secretKeyBytes = secretKey.getEncoded();
		return secretKeyBytes;
	}
  
    public static String decrypt(byte[] encryptBytes, String password) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, InvalidAlgorithmParameterException {  
        // key
    	byte[] secretKeyBytes = getSecretKey(password);
        
        // SecretKeySpec IvParameterSpec
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKeyBytes, "AES");  
		IvParameterSpec ivParameterSpec = new IvParameterSpec(IV_STRING.getBytes()); // IV
		
		// BouncyCastleProvider
        //Security.addProvider(new BouncyCastleProvider());  
        
        Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding", "BC");  
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);  
        
        byte[] decryptBytes = cipher.doFinal(encryptBytes);
        
        return new String(decryptBytes, DATA_ENCODE);
    }  
  
      
    private static byte[] tohash256Deal(String datastr) {  
        try {  
            MessageDigest digester=MessageDigest.getInstance("SHA-256");  
            digester.update(datastr.getBytes());  
            byte[] hex=digester.digest();  
            return hex;   
        } catch (NoSuchAlgorithmException e) {  
            throw new RuntimeException(e.getMessage());    
        }  
    }  
      

}