package com.hqxu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *  
 *----DBUtil类 作用： 
 * 1.getConnection() 获取Connection对象
 * 2.close() 释放资源
 * 
 *
 */

public class DBUtil {
	
	//
	public static Connection getConnection()
	{
		Connection conn=null;
		
		try{
			//1.加载驱动类
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.获取连接对象
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","123456");  //localhost   1528端口号打开 Net Manager 本地 服务命名查看  
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return conn;	
		
	}
	
	//释放资源
	public static void close(ResultSet rs,Statement stmt,Connection conn)
	{
		if(rs != null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(stmt != null)
		{
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}
	
	
	public static void main(String[] args) {
		
		//测试是否连接数据库成功
		Connection conn=getConnection();
		System.out.println(conn==null); //false 连接成功
		close(null,null,null);

	}

}
