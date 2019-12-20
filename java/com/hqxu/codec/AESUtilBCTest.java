package com.hqxu.codec;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class AESUtilBCTest {
	
	public static final String PASSWORD = "12345678"; // to create random
	
	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, NoSuchProviderException {
		
		String data = "hello world";
		
		System.out.println(AESUtilBC.decrypt(AESUtilBC.encrypt(data, PASSWORD), PASSWORD));
	}
}
