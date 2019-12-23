package com.hqxu.io.bio.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class IOUtil {

	/**
	 * read specific number bytes from inputstream
	 * but not ensure actually read number equals specific number
	 * 
	 * @param in
	 * @param length
	 * @return
	 * @throws IOException
	 */
	public static byte[] readBytes(InputStream in, long length) throws IOException {
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int read = 0;
		while (read < length) {
			int cur = in.read(buffer, 0, (int) Math.min(1024L, length - read));
			if (cur < 0) {
				break;
			}
			read += cur;
			bo.write(buffer, 0, cur);
		}
		return bo.toByteArray();
	}
	
	/**
	 * read String from inputstream
	 * @param in
	 * @param encode
	 * @return
	 * @throws IOException
	 */
    public static String readString(InputStream in, String encode) throws IOException{
        BufferedReader br = null;
        br = new BufferedReader(new InputStreamReader(in, encode));
        StringBuilder sb = new StringBuilder("");
        String temp;
        while ((temp = br.readLine()) != null){
            sb.append(temp);
        }
        return sb.toString();
    }

    
    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
    	InputStream in = new ByteArrayInputStream("你们好吗哈哈哈11222h你们hhe你好".getBytes("utf-8"));
	}
    
    
}
