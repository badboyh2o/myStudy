package com.hqxu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * EmpDao类： 访问数据库
 *
 */


public class EmpDao {
	
	private final static String QUERY_EMPS="select empno,ename,job,sal from emp1";	
	private static final String QUERY_EMPS_BY_EMPNO="select empno,ename,job,sal from emp1 where empno=?";
	private static final String ADD_EMP = "insert into emp1 (empno,ename,job,sal) values(seq_emp_empno.nextval,?,?,?)"; //
	private static final String DELETE_EMP ="delete from emp1 where empno=?";
	private static final String UPDATE_EMP = "update emp1 set ename=?,job=?,sal=? where empno=?";
	
	
	public static void main(String[] agrs){
		
		//查询所有记录
		EmpDao dao11=new EmpDao();
		List<Emp> emp11 =dao11.queryEmps();
		System.out.println(emp11);		
		
		/*
		//查询某个员工的信息
		EmpDao dao=new EmpDao();
		Emp emp =dao.queryEmpByEmpno(7369);
		System.out.println(emp);
		
		//添加记录
		EmpDao dao1=new EmpDao();
		Emp emp1=new Emp();
		
		emp1.setEname("hqxu");
		emp1.setSal(6000.00);
		emp1.setJob("java");
		int rows=dao1.addEmp(emp1);
		System.out.println(rows);
		

		//更新记录
		EmpDao dao2=new EmpDao();
		Emp emp2=new Emp();
		emp2.setEmpno(21); //需要更新的员工
		emp2.setEname("wenzhi");
		emp2.setSal(5000.00);
		emp2.setJob("javase");
		int rows1=dao2.updateEmp(emp2);
		System.out.println(rows1);
		
		
		//删除一个记录
		EmpDao dao3=new EmpDao();
		int rows2=dao.deleteEmp(21);
		System.out.println(rows2);
		
			//批量删除记录
		EmpDao dao4=new EmpDao();
		int[] empnos={22,23,24};
		for(int empno:empnos)
		{
			dao.deleteEmp(empno);
			
		}
*/
		
	}
	
	
		//查询所有员工信息
		public List<Emp> queryEmps()
		{
			//声明要返回的数据
			List<Emp> list=new ArrayList<>();
			
				//1. 声明三个变量
			Connection conn =null;
			PreparedStatement stmt=null;
			ResultSet rs=null;
			
			try{

				//2. 获取连接对象	
				conn=DBUtil.getConnection();
					
				//3.获取数据库操作对象Statement
				stmt=conn.prepareStatement(QUERY_EMPS);
				
				//4.执行sql语句
				rs=stmt.executeQuery();
				
				//5.把查询的结果集中的数据拿出来放进我们应用中，一条数据，那么用一个Emp对象存放就好
				Emp emp=null;
				while(rs.next())
				{
					//6. 从 rs 中获取数据
					emp=new Emp();//1111  1112
					//emp.setEmpno(rs.getInt(1));//尽量不要用这种,1是查询列在结果集中的索引
					emp.setEmpno(rs.getInt("empno"));//建议采用这种，empno是查询列在结果集中的列名
					emp.setEname(rs.getString("ename"));
					emp.setJob(rs.getString("job"));
					emp.setSal(rs.getDouble("sal"));
					//7. 把对象放入集合
					list.add(emp);
			}
			}catch(SQLException e)
			{
				e.printStackTrace();
			}finally
			{
				DBUtil.close(rs,stmt,conn);
			}
			
			//8. 返回数据
			return list;
		}
		
		
		
		
		
		//查询一个员工的信息
		public Emp queryEmpByEmpno(int empno)
		{
			Emp emp=null;
			Connection conn=null;
			PreparedStatement stmt=null;
			ResultSet rs=null;
			
			try{
				conn=DBUtil.getConnection();
				stmt= conn.prepareStatement(QUERY_EMPS_BY_EMPNO);
				//给占位符赋值
				stmt.setInt(1,empno);
				
				rs=stmt.executeQuery();
				
				if(rs.next())
				{
					//拿数据
					emp=new Emp();
					//emp.setEmpno(rs.getInt(1));//尽量不要用这种
					emp.setEmpno(rs.getInt("empno"));//建议采用这种
					emp.setEname(rs.getString("ename"));
					emp.setJob(rs.getString("job"));
					emp.setSal(rs.getDouble("sal"));
				}
			}catch(SQLException e)
			{
				e.printStackTrace();
			}finally
			{
				DBUtil.close(rs, stmt, conn);
			}
			
			return emp;
		}
		
		
		
		
		//添加记录
		public int addEmp(Emp emp)
		{
			int rows=0;
			Connection conn=null;
			PreparedStatement stmt=null;
			try{
				conn=DBUtil.getConnection();
				stmt=conn.prepareStatement(ADD_EMP);
				
				//给3个占位符赋值
				stmt.setString(1, emp.getEname());
				stmt.setString(2, emp.getJob());
				stmt.setDouble(3, emp.getSal());
				
				rows=stmt.executeUpdate();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}finally
			{
				DBUtil.close(null, stmt, conn);
			}
			return rows;
		}
		
		
		//更新记录
		public int updateEmp(Emp emp)
		{
			int rows=0;
			Connection conn=null;
			PreparedStatement stmt=null;
			try{
				conn=DBUtil.getConnection();
				stmt=conn.prepareStatement(UPDATE_EMP);
				
				//给占位符赋值
				stmt.setString(1,emp.getEname());
				stmt.setString(2,emp.getJob());
				stmt.setDouble(3, emp.getSal());
				stmt.setInt(4,emp.getEmpno());
				
				rows=stmt.executeUpdate();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}finally
			{
				DBUtil.close(null, stmt, conn);
			}
			return rows;
		}
		
		
		
		
		
		//删除记录
		public int deleteEmp(int empno)
		{
			int rows=0;
			
			Connection conn=null;
			PreparedStatement stmt=null;
			try{
				conn=DBUtil.getConnection();
				stmt=conn.prepareStatement(DELETE_EMP);
				
				//给占位符赋值
				stmt.setInt(1, empno);
				rows=stmt.executeUpdate();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}finally
			{
				DBUtil.close(null,stmt,conn);
			}
			
			return rows;
		}
		
		
		
		
		


}
