package com.hqxu.testIOStream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class testStreamClose {

	
	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("H:/1.txt");
		test1(is);
		is.close();
	}
	
	public static void test1(InputStream is) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = null;
		while((line=br.readLine()) != null)
		{
			System.out.println(line);
		}
	}
	
	
}
