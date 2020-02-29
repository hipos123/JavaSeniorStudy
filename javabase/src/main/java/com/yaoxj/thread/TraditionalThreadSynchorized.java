package com.yaoxj.thread;

//线程互斥，所谓线程互斥，就是一个茅坑，只有人蹲完坑之后，另一个人才可以进来。
public class TraditionalThreadSynchorized {

	public static void main(String[] args) {
		init();
	}
	
	private static void init() {
		final Outputer output=new Outputer();
		//-------------begin-------------------
		//这种方式情况下运行，线程会互相竞争，出来的数据会有不准确
		/*new Thread(new Runnable() {
			public void run() {
				while(true){
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					output.output("yaoxj");
				}
			
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				while(true){
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					output.output("hangsome man");
				}
			}
		}).start();*/
		
		//-------------------------end-----------------
		
		//--------------begin---------------------
		new Thread(new Runnable() {
			public void run() {
				while(true){
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					output.output4("yaoxj");
				}
			
			}
		}).start();
		
		
		new Thread(new Runnable() {
			public void run() {
				while(true){
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					output.output4("hangsome man");
				}
			}
		}).start();
		
	}

}
class Outputer{
	public void output(String name){
		int len=name.length();
		for (int i = 0; i < len; i++) {
			System.out.print(name.charAt(i));
		}
		System.out.println();
	}
	
	public void output2(String name){
		//-------synchronized在一个对象上进行这段代码的互斥。由于name每次是不一样的，所以这个输出的结果也不是正常的。
		synchronized(name){
			int len=name.length();
			for (int i = 0; i < len; i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
	}
	
	//定义一个变量，针对的都是这个变量进行互斥，只有这个线程的这段代码执行完成之后，开关才关闭掉，才允许下一个线程进来执行。
	//由于mykey都是同一个对象，所以这边是可以互斥的
	public void output3(String name){
		String mykey="";
		synchronized(mykey){
			int len=name.length();
			for (int i = 0; i < len; i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
	}
	
	//把这个关键字提取到方法上，表示这个方法是互斥的，只有这个对象消费完之后，才允许下一个线程执行
	//由于output是同一个对象，所以线程会互斥
	public synchronized void output4(String name){
		String mykey="";
			int len=name.length();
			for (int i = 0; i < len; i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
	}
	
	//可以用同一个字节码，也是互斥的
	public void output5(String name){
		synchronized(TraditionalThreadSynchorized.class){
			int len=name.length();
			for (int i = 0; i < len; i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
	}
}
