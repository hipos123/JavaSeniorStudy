package com.yaoxj.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallAbleAndFutre {
	public static void main(String[] args) {
		ExecutorService threadExecutor = Executors.newSingleThreadExecutor();
		//threadExecutor���˿���ʹ��execute��ִ���̣߳�������ʹ��submit�����������̡߳�
		//threadExecutor.submit ����Future
		Future<Integer> submit = threadExecutor.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				Thread.sleep(20000);
				return 100;
			}
		});
		System.out.println("�ȴ�������أ�");
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
