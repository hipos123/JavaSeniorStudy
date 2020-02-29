package com.yaoxj.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsPoolTest {

	private static ScheduledExecutorService newSingleThreadScheduledExecutor;

	public static void main(String[] args) {
		// 线程池测试
		int nThreads = 3;
		//创建3个固定的线程池,虽然有10次循环操作，但是只有三个线程服务，所以每次只有3个线程操作。
//		ExecutorService threadPool=Executors.newFixedThreadPool(nThreads);
		
		//根据实际的任务数量，动态的创建线程
//		ExecutorService threadPool=Executors.newCachedThreadPool();
		
		//每次只会生成一个线程，当前线程死掉之后，会马上生成一个新的线程
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
						System.out.println(Thread.currentThread().getName()+"循环了"+j+"次,外层的第"+task+"循环");
					}
				}
			});
		}
		threadPool.shutdown();
		
		Executors.newScheduledThreadPool(3).schedule(new Runnable() {
			@Override
			public void run() {
				System.out.println("任务10秒之后，执行一次");
			}
		}, 10, TimeUnit.SECONDS);
		
		Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("任务6秒之后，执行一次,接着每两秒执行一直");
			}
		}, 6,2, TimeUnit.SECONDS);
	
		

	}

}
