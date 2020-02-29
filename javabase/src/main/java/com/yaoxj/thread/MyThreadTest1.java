package com.yaoxj.thread;

public class MyThreadTest1 {

	public static void main(String[] args) {
		
		//线程的生成方式1：通过子类实现run方法，覆盖父类的run方法。
		Thread thread1=new Thread(){
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(1000);
						System.out.println("this is thread1:"+Thread.currentThread().getName());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread1.start();
		
		//线程的生成方式2：构造函数传递runnable对象，调用run方法
		Thread thread2=new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(1000);
						System.out.println("this is thread2:"+Thread.currentThread().getName());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread2.start();
		
		
		//线程既有构造函数，也有覆盖父类的run方法的时候，执行子类的run方法。runnable的run方法不会执行。
		Thread thread3=new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(1000);
						System.out.println("this is thread4:"+Thread.currentThread().getName());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}){
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(1000);
						System.out.println("this is thread3:"+Thread.currentThread().getName());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread3.start();
		

	}

}
