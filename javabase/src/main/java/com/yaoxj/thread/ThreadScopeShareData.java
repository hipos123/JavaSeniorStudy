package com.yaoxj.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import sun.text.normalizer.Trie.DataManipulate;

public class ThreadScopeShareData {

	private static Map dataMap=new HashMap<Thread, Integer>();
	public static void main(String[] args) {

		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int data=new Random().nextInt();
					dataMap.put(Thread.currentThread(), data);
					System.out.println("main Thread:"+Thread.currentThread().getName()+"&&data:"+data);
					new AClazz().getData();
					new BClazz().getData();
				}
			}).start();
		}
	}

	static class AClazz{
		public void getData(){
			int data=(int) dataMap.get(Thread.currentThread());
			System.out.println("A class:"+Thread.currentThread().getName()+"&&data:"+data);
		}
	}
	static class BClazz{
		public void getData(){
			int data=(int) dataMap.get(Thread.currentThread());
			System.out.println("B class:"+Thread.currentThread().getName()+"&&data:"+data);
		}
	}
}




