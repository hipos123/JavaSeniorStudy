package com.yaoxj.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import sun.text.normalizer.Trie.DataManipulate;

public class ThreadLocalTest {

	private static Map dataMap=new HashMap<Thread, Integer>();
	//ThreadLocal就有点类似与一个map，只是他的key就是当前的线程，在同一个线程中，他的值是共享的。
	static ThreadLocal<Integer> myThreadLocal=new ThreadLocal<Integer>();
	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int data=new Random().nextInt();
					dataMap.put(Thread.currentThread(), data);
					myThreadLocal.set(data);
					System.out.println("main Thread:"+Thread.currentThread().getName()+"&&data:"+data);
					new AClazz().getData();
					new BClazz().getData();
				}
			}).start();
		}
	}

	static class AClazz{
		public void getData(){
//			int data=(int) dataMap.get(Thread.currentThread());
			int data=myThreadLocal.get();
			System.out.println("A class:"+Thread.currentThread().getName()+"&&data:"+data);
		}
	}
	static class BClazz{
		public void getData(){
//			int data=(int) dataMap.get(Thread.currentThread());
			int data=myThreadLocal.get();
			System.out.println("B class:"+Thread.currentThread().getName()+"&&data:"+data);
		}
	}
}


class MyThreadLocalData{
	private MyThreadLocalData(){
		
	}
	//一开始就生成了这个对象，单例直接返回这个对象，这种模式就饱汉模式,不论你有没有调用这个类，这个对象都已经生成出来了
	private static MyThreadLocalData instance=new MyThreadLocalData();
		
	private static MyThreadLocalData getInstace(){
		return instance;
	}
	
	//============================完美分割线==================
	

	private static synchronized MyThreadLocalData getInstace2(){
		if(instance2==null)instance2=new MyThreadLocalData();
		return instance2;
	}
	//一开始这个对象就是空的。在使用单例的时候，再去初始化这个对象，就做饥汉模式
	// 这种模式在多线程的情况下，切换线程的时候，这个对象就可能就不一样了。随着切换了，得到的永远是最后一个，
	//如果非得用这种模式，就得在这个单例上加上一个线程互斥
	private static MyThreadLocalData instance2=null;
}




