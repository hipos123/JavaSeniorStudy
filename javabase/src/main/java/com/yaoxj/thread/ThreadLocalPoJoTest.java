package com.yaoxj.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import sun.text.normalizer.Trie.DataManipulate;

public class ThreadLocalPoJoTest {

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
					MyThreadScopeData.getInstace().setName("name"+data);
					MyThreadScopeData.getInstace().setAge(data);
					new AClazz().getData();
					new BClazz().getData();
				}
			}).start();
		}
	}

	static class AClazz{
		public void getData(){
//			int data=(int) dataMap.get(Thread.currentThread());
//			int data=myThreadLocal.get();
			MyThreadScopeData myThreadScopeData=MyThreadScopeData.getInstace();
			System.out.println("A class:"+Thread.currentThread().getName()+
					"&&name:"+myThreadScopeData.getName()
					+"&&data:"+myThreadScopeData.getAge());
		}
	}
	static class BClazz{
		public void getData(){
//			int data=(int) dataMap.get(Thread.currentThread());
//			int data=myThreadLocal.get();
			MyThreadScopeData myThreadScopeData=MyThreadScopeData.getInstace();
			System.out.println("A class:"+Thread.currentThread().getName()+
					"&&name:"+myThreadScopeData.getName()
					+"&&data:"+myThreadScopeData.getAge());
		}
	}

}

class MyThreadScopeData{
	static  ThreadLocal<MyThreadScopeData> myThreadScope=new ThreadLocal<MyThreadScopeData>();
	private MyThreadScopeData(){
		
	}
  public static MyThreadScopeData getInstace(){
		MyThreadScopeData instance=myThreadScope.get();
		if(instance==null){
			instance=new MyThreadScopeData();
			myThreadScope.set(instance);
		}
		return instance;
	}
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}






