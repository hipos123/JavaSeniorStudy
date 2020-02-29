package com.yaoxj.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallAbleAndFutre {
	public static void main(String[] args) {
		ExecutorService threadExecutor = Executors.newSingleThreadExecutor();
		//threadExecutor除了可以使用execute来执行线程，还可以使用submit方法来操作线程。
		//threadExecutor.submit 返回Future
		Future<Integer> submit = threadExecutor.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				Thread.sleep(20000);
				return 100;
			}
		});
		System.out.println("等待结果返回：");
		try {
			System.out.println(submit.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
