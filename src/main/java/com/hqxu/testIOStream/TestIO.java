package com.hqxu.testIOStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class TestIO implements Serializable {

	
	
	public static void main(String[] args) {
		
		testByteArrayIOStream();
		
		testDataIOStream();
		
		testBFileInputStream();
		
		testBufferedInputStream();
		
		
		testObjectIOStreamr();
		
		testInputStreamReader();
		
	}
	
	
	//节点流 ByteArrayIOStream
	public static void testByteArrayIOStream()
	{
		System.out.println("======================  testByteArrayIOStream  ==========================");
		
		ByteArrayInputStream bis = new ByteArrayInputStream("大家好haha".getBytes());
		ByteArrayInputStream bis1 = new ByteArrayInputStream("大家好！haha".getBytes());
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ByteArrayOutputStream bos1 = new ByteArrayOutputStream(); //ByteArrayOutputStream： 在构造的时候，不用定义数据目的，因为该对象中已经内部封装了可变长度的字节数组。
		int byteContent= -1;
		while((byteContent = bis.read()) != -1)
		{
			bos.write(byteContent);
		}
		System.out.println("读取byteArrayInputStream 全部bytes: "+bos.toString());
		
		byte[] buffer = new byte[4];
		try {
			bis1.read(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		bos1.write(buffer, 0, buffer.length);
		System.out.println("读取byteArrayInputStream 4 bytes:   "+bos1.toString());
		System.out.println("PS： 一个汉字 3 bytes");
	}
	
	
	
	//节点流  FileInputStream
	public static void testBFileInputStream()
	{
		System.out.println("======================  testBFileInputStream  ==========================");
		//构建输入流
		FileInputStream  fis =null;
		try {
			fis = new FileInputStream(new File("H:\\1.txt"));
			
			//缓冲字节数组
			byte[] buffer = new byte[1024];
			
			//实际从输入流中读入的字节数量
			int hasRead = 0;
			while((hasRead = fis.read(buffer)) > 0)
			{
				System.out.println(new String(buffer,0,hasRead,"GBK"));  //指定编码格式输出
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally
		{
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//fis.close()来关闭该文件的输入流，与JDBC编程一样，程序里面打开的文件IO资源不属于内存的资源，垃圾回收机制无法回收该资源，所以应该显示的关闭打开的IO资源。Java 7改写了所有的IO资源类，它们都实现了AntoCloseable接口，因此都可以通过自动关闭资源的try语句来关闭这些Io流。
		}
	}

	//处理流 DataOutputStream
	public static void testDataIOStream()
	{
		System.out.println("======================  testDataIOStream  ==========================");
		try 
		{
			//建立输出流
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			DataOutputStream out = new DataOutputStream(bos);
			
			//输出数据
	        out.writeInt(1);
	        System.out.println("DataOutputStream: "+out.size()+";  writeInt, Int 4 bytes ;");
	        out.writeUTF("你");
	        System.out.println("DataOutputStream: "+out.size()+";  writeUTF, String 2 bytes + 一个汉字3 bytes");
	        out.writeBoolean(true);
	        System.out.println("DataOutputStream: "+out.size()+"; writeBoolean, boolean 1 byte ;");
	        
	        out.flush();
	        out.close();
		}
		catch(IOException  e)
		{
			e.printStackTrace();
		}
	}
	
	
	//处理流 BufferedInputStream
	public static void testBufferedInputStream()
	{
		System.out.println("======================  testBufferedInputStream  ==========================");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			fis = new FileInputStream("H:\\1.txt");
			fos = new FileOutputStream("H:\\2.txt");
			//创建字节缓存流
			bis = new BufferedInputStream(fis);            //BufferedInputStream 自带默认缓存，先从流读入数据到其中的缓冲区，再读入到byte[] b ?
			bos = new BufferedOutputStream(fos);
			
			byte[] b = new byte[1024];    // 这个不是 缓冲
			int hasRead = 0;
			
			while((hasRead=bis.read(b))>0)
			{
				bos.write(b, 0, hasRead);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally
		{
			try {
				bis.close();
				bos.close();                //写完需要flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	//转换流 InputStreamReader
	public static void testInputStreamReader()
	{
		System.out.println("======================  testInputStreamReader  ==========================");
		System.out.println("======================  在控制台输入内容，enter确认输入，输入exit则结束  ==========================");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		String buffer = null;
		try {
			while((buffer=br.readLine()) != null)
			{
				if(buffer.equals("exit"))
				{
					System.exit(1);
				}
				System.out.println(buffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//处理流 ObjectInputStream
	public static void testObjectIOStreamr()
	{
		System.out.println("======================  testObjectIOStreamr  ==========================");
		ObjectOutputStream oos =  null;
		ObjectInputStream ois = null;
		try {
			oos = new ObjectOutputStream (new BufferedOutputStream(new FileOutputStream("H:\\1.tem")));
			oos.writeObject(new TestIO().new Person(27,"hqxu"));
			oos.close();
			
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("H:\\1.tem")));
			Person  p = (Person)ois.readObject();
			System.out.println(p);
			
			ois.close();
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	//内部类
	class Person implements Serializable 
	{
		
		private int age;
		private String name;
		
		
		public Person(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}


		@Override
		public String toString() {
			return "Person [age=" + age + ", name=" + name + "]";
		}


		public Person()
		{
		}
		
	}
	
	
	
	
	
	
	
}
