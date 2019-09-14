package com.hqxu.Class.Thread;

public class ProduceOrConsumeBread {

	public static void main(String[] args) {
	    
	    // 实体
		Bread bread=new Bread();
		
		ProduceThread p1=new ProduceThread(bread);
		ProduceThread p2=new ProduceThread(bread);
		
		ConsumerThread c1=new ConsumerThread(bread);
		ConsumerThread c2=new ConsumerThread(bread);
		
		// 四个线程访问同一个实体
		new Thread(p1).start();
		new Thread(p2).start();
		new Thread(c1).start();
		new Thread(c2).start();

	}

}
