package com.yaoxj.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import sun.text.normalizer.Trie.DataManipulate;

public class ThreadLocalTest {

	private static Map dataMap=new HashMap<Thread, Integer>();
	//ThreadLocal���е�������һ��map��ֻ������key���ǵ�ǰ���̣߳���ͬһ���߳��У�����ֵ�ǹ���ġ�
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
	//һ��ʼ��������������󣬵���ֱ�ӷ��������������ģʽ�ͱ���ģʽ,��������û�е�������࣬��������Ѿ����ɳ�����
	private static MyThreadLocalData instance=new MyThreadLocalData();
		
	private static MyThreadLocalData getInstace(){
		return instance;
	}
	
	//============================�����ָ���==================
	

	private static synchronized MyThreadLocalData getInstace2(){
		if(instance2==null)instance2=new MyThreadLocalData();
		return instance2;
	}
	//һ��ʼ���������ǿյġ���ʹ�õ�����ʱ����ȥ��ʼ��������󣬾�������ģʽ
	// ����ģʽ�ڶ��̵߳�����£��л��̵߳�ʱ���������Ϳ��ܾͲ�һ���ˡ������л��ˣ��õ�����Զ�����һ����
	//����ǵ�������ģʽ���͵�����������ϼ���һ���̻߳���
	private static MyThreadLocalData instance2=null;
}




