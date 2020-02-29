package com.yaoxj.thread;

public class MyThreadTest1 {

	public static void main(String[] args) {
		
		//�̵߳����ɷ�ʽ1��ͨ������ʵ��run���������Ǹ����run������
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
		
		//�̵߳����ɷ�ʽ2�����캯������runnable���󣬵���run����
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
		
		
		//�̼߳��й��캯����Ҳ�и��Ǹ����run������ʱ��ִ�������run������runnable��run��������ִ�С�
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
