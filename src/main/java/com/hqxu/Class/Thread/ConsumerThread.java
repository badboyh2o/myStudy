package com.hqxu.Class.Thread;

public class ConsumerThread implements Runnable {

    // 实体
	private Bread bread;
	public ConsumerThread(Bread bread)
	{
		this.bread=bread;
	}
	
	public void consumer()
	{
		int i=100;
		while(i>0)
		{
			bread.consumer();
			i--;
		}
	}

	@Override
	public void run() {
	    // 访问实体
		consumer();
	}

}
