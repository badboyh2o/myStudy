package com.hqxu.Class.Thread;

public class ProduceThread implements Runnable {
    //访问实体
	private Bread bread;
	public ProduceThread(Bread bread)
	{
		this.bread=bread;
	}
	
	public void product()
	{
		int i=100;
		while(i>0)
		{
			bread.product();
			i--;
		}
	}

	@Override
	public void run() {
	    // 访问实体
	    product();
	}

}
