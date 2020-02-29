package com.yaoxj.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsPoolTest {

	private static ScheduledExecutorService newSingleThreadScheduledExecutor;

	public static void main(String[] args) {
		// �̳߳ز���
		int nThreads = 3;
		//����3���̶����̳߳�,��Ȼ��10��ѭ������������ֻ�������̷߳�������ÿ��ֻ��3���̲߳�����
//		ExecutorService threadPool=Executors.newFixedThreadPool(nThreads);
		
		//����ʵ�ʵ�������������̬�Ĵ����߳�
//		ExecutorService threadPool=Executors.newCachedThreadPool();
		
		//ÿ��ֻ������һ���̣߳���ǰ�߳�����֮�󣬻���������һ���µ��߳�
		ExecutorService threadPool=Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			final int task=i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 10; j++) {
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()+"ѭ����"+j+"��,���ĵ�"+task+"ѭ��");
					}
				}
			});
		}
		threadPool.shutdown();
		
		Executors.newScheduledThreadPool(3).schedule(new Runnable() {
			@Override
			public void run() {
				System.out.println("����10��֮��ִ��һ��");
			}
		}, 10, TimeUnit.SECONDS);
		
		Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("����6��֮��ִ��һ��,����ÿ����ִ��һֱ");
			}
		}, 6,2, TimeUnit.SECONDS);
	
		

	}

}
