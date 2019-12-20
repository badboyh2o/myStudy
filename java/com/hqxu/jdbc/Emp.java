package com.hqxu.jdbc;

/**
 *  Emp类 用于保存Emp表的行记录
 */


public class Emp {
	
	private int empno;
	private String ename;
	private String job;
	private double sal;

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job
				+ ", sal=" + sal + "]";
	}
	

	
	

	public static void main(String[] args) {
		
	}

}
