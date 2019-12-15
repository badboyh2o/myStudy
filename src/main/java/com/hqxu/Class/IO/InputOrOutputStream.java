package com.hqxu.Class.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

/**
 * 
 * 一、IO基本概念
 * 
 *  深入分析 Java I/O 的工作机制
 *  https://www.ibm.com/developerworks/cn/java/j-lo-javaio/index.html
 *  Java IO
 *  https://blog.csdn.net/suifeng3051/article/details/48344587
 *  
 *  不同IO模型的实现方式：缓存IO、直接IO、内存映射
 *  https://blog.csdn.net/pakko/article/details/8779110
 *  不同IO模型的实现方式
 *  https://blog.csdn.net/weixin_39446980/article/details/85235537
 *  不同IO模型的实现方式 
 *  https://www.cnblogs.com/hapjin/p/5736188.html
 *      
 *      
 *      数据源(一切皆文件)：
 *          文件(File、RandomAccessFile)   磁盘IO
 *          网络(Socket)   网络IO
 *          控制台
 *  
 *  
 * 
 * 
 *  1.Input,读入：指字节从数据源(磁盘文件、socket、JVM内存、其他应用) ——(内核空间[页缓存])——> 到当前应用的JVM[用户空间];
 *    Output,写出：  指字节从当前应用的JVM[用户空间] ——(内核空间[页缓存])——> 数据源(磁盘文件、socket、其他应用、JVM内存).
 *  
 *  
 *  2.流：可以理解为字节在物理数据源和JVM之间传输形成字节流。流使用完后应该关闭。
 *    输入流：从物理数据源读入到JVM的数据流;
 *    输出流：从JVM输出到物理数据源的数据流。
 *    
 *  
 *  3.流的基本单元
 *    流操作的基本单元可以是一个字节 或者 一个字符（两个字节）。
 *    一次读写一个字节或者一个字符。
 * 
 *  4.流的划分
 *    1）按流的方向
 *        输入流:
 *        输出流:
 *    2）按流的操作单元
 *        字节流:
 *        字符流:
 *    3）按流的角色
 *        节点流(低级流): 能够直接向数据源写入、读取数据;
 *        处理流(高级流): 封装了节点流。
 *          
 * 
 *  
 *  
 * 一、IO流的四个抽象基类
 *  
 *  InputStream、OutputStream、Reader、Writer
 *  
 *  public abstract class InputStream implements Closeable {}
 *  public abstract class OutputStream implements Closeable, Flushable {}
 *  public abstract class Reader implements Readable, Closeable {}
 *  public abstract class Writer implements Appendable, Closeable, Flushable {}
 * 
 * 
 * 1.InputStream
 *  1）public abstract int read() throws IOException;
 *      一次读取一个字节，以int的类型返回；
 *      当读到结尾，返回 -1 
 *  2）public int read(byte b[]) throws IOException{}
 *      一次最多读入一个b.length长度的字节到数组 b[]中；返回实际读取到的字节数；
 *     读到结尾将返回-1 
 *  3）public int read(byte b[], int off, int len) throws IOException()
 *      一次最多读取len个字节的数据，并将其存储在数组b中，
 *      放入数组b中时，并不是从数组起点开始，而是从off位置开始，返回实际读取的字节数。
 *      读到结尾将返回-1 
 *      
 *      
 * 2.OutputStream
 *  1）void write(int c); 将指定的字节输出到输出流中;
 *  2）void write(byte[] b); 将字节数组中的全部数据输出到指定输出流中；
 *  3）void write(byte[] b, int off, int len); 将字节数组中从off位置开始，长度为len的字节输出到输出流中。
 *  
 * 3.Reader
 *   与 InputStream 类似
 *   int read(); 从输入流中读取单个字符，返回所读取的字符数据（字节数据可直接转换为int类型）；
 *   int read(char[] b)从输入流中最多读取b.length个字符的数据，并将其存储在字节数组b中，返回实际读取的字符数。
 *   int read(char[] b,int off,int len); 从输入流中最多读取len个字符的数据，并将其存储在数组b中，
 *                                       放入数组b中时，并不是从数组起点开始，而是从off位置开始，返回实际读取的字符数。
 *   
 * 4.Writer
 *   与OutputStream 类似
 *   void write(int c); 将指定的字符输出到输出流中；
 *   void write(char[] buf); 将字符数组中的数据输出到指定输出流中；
 *   void write(char[] buf, int off,int len ); 将字符数组中从off位置开始，长度为字符输出到输出流中
 *   
 *   //字符串底层是 char[]
 *   void write(String str); 将str字符串里包含的字符输出到指定输出流中。
 *   void write (String str, int off, int len); 将str字符串里面从off位置开始，长度为len的字符输出到指定输出流中。
 *   
 * 
 * 
 * 
 *   
 * 二、高级流
 * 
 * 2.1 缓冲流
 * 
 *  BufferedInputStream
 *  BufferedOutputStream
 *  BufferedReader
 *  BufferedWriter
 * 
 *  1.BufferedReader
 *   1）public String readLine() throws IOException {}
 *      读入一行；如果到达结尾，返回 null
 *      
 *  2.BufferedWriter
 *   1）public void write(String s, int off, int len) throws IOException {
 *      写入一个字符串
 *   2）public void write(String str) throws IOException {}
 *      写入一个字符串
 *   3）public void newLine() throws IOException {}
 *      写入一个换行符
 *      
 *   
 *   
 * 2.2 转换流  
 *  InputStreamReader     将 InputStream 转为 BufferedReader
 *  OutputStreamWriter    将 OutputStream 转为 BufferedWriter
 *  
 *   
 *  1.public InputStreamReader(InputStream in) { }
 *  
 *  2.public OutputStreamWriter(OutputStream out) {}
 *  
 *  
 *   
 *   
 * 三、IO使用注意事项
 * 
 *   1.使用完毕应该关闭流
 *      保证流占用的物理资源被回收；
 *      将输出流缓冲区中的数据flush到物理节点中里（因为在执行close()方法之前，自动执行输出流的flush()方法）。
 *   
 *   2.只需要关闭最上层的处理流,jvm自动关闭下层的节点流。
 *   
 *   3.如果是操作二进制文件就使用字节流，如果操作的是文本文件就使用字符流。
 *   
 *   4.尽可能的多使用处理流，这会代码更加灵活，复用性更好。
 * 
 * 
 * 四、传统IO的特点
 * 
 *  
 * 
 *  1.输入/输出都是同步、阻塞的;
 *       同步：read() 、 write() 方法都是同步I/O,每一次调用都可以知道（操作系统的？）IO结果；
 *       阻塞：读/写不到(一个字节)数据，就挂起当前线程？直至有可供读取的数据或者可以写入数据
 *  2.效率低; 通过字节的移动来处理的（即使我们不直接处理字节流，但底层实现还是依赖于字节处理）。
 *  
 *  
 * 五、NIO
 * 
 *      https://www.ibm.com/developerworks/cn/education/java/j-nio/j-nio.html NIO入门
 * 
 *  1.特点：
 *      同步、非阻塞
 *  2.
 *   NIO采用了内存映射对象的方式来处理输入和输出，NIO将文件或者文件的一块区域映射到内存中，
 *   这样就可以像访问内存一样来访问文件了。通过这种方式来进行输入/输出比传统的输入和输出要快的多。 
 * 
 */


public class InputOrOutputStream implements Serializable {
    private static final long serialVersionUID = 1L;



    // 测试 输入输出流
	public static void main(String[] args) {
		
	    // 1.1 测试 节点流 - 内存
		testByteArrayIOStream();
		// 1.2 测试 节点流 - 文件
	    testBFileInputStream();
		
	    
	    // 2.1 测试 处理流 - Data
		testDataIOStream();
		// 2.2 测试 处理流 - 缓冲
		testBufferedInputStream();
		// 2.3 测试 处理流 - Object
		testObjectIOStreamr();

		
		// 3.1 测试转换流
		testInputStreamReader();
		
	}
	
	
	
	
	
	//1.1节点流 -  ByteArray IOStream
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
	
	
	
	//1.2.节点流  File IO Stream
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

	//2.1 处理流 Data OutputStream
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
	
	
	// 2.2 处理流 BufferedInputStream
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
			
			byte[] b = new byte[1024];    // 这个不是 缓冲；这是流的一个端点
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
	
	//2.3 处理流 ObjectInputStream
    public static void testObjectIOStreamr()
    {
        System.out.println("======================  testObjectIOStreamr  ==========================");
        ObjectOutputStream oos =  null;
        ObjectInputStream ois = null;
        try {
            oos = new ObjectOutputStream (new BufferedOutputStream(new FileOutputStream("H:\\1.tem")));
            oos.writeObject(new InputOrOutputStream().new Person(27,"hqxu"));
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
    
    
	
	//3.1 转换流 InputStreamReader
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
	

	
	//测试使用的 内部类
	class Person implements Serializable {
        private static final long serialVersionUID = 1L;
        
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
