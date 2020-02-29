package com.yaoxj.lambda;

import java.util.concurrent.Callable;

public class Test3 {

	public static void main(String[] args) throws Exception {
		Runnable r=new Runnable() {
			@Override
			public void run() {
				System.out.println("�޲κ���ʽ�ӿڣ��޷���ֵ");
			}
		};
		r.run();
		
		Runnable r1= () -> {System.out.println("r1�޲κ���ʽ�ӿڣ��޷���ֵ");};
		
		
		//�򵥵ĺ����壬������Ҫ{}
		Runnable r2= () -> System.out.println("r2�޲κ���ʽ�ӿڣ��޷���ֵ");
		r1.run();
		r2.run();
		
		
		
		Callable<String> c=new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "c-->hello";
			}
		};
		System.out.println(c.call());
		
		Callable<String> c1=() -> {return "c1-->hell0";};
		//�߼��ǳ��򵥣�����Ҫreturn
		Callable<String> c2=() ->  "c2-->hell0";
		
		System.out.println(c1.call());
		System.out.println(c2.call());
		
		UserMapper u=new UserMapper() {
			@Override
			public int delete() {
				return 0;
			}
		};
		
		System.out.println(u.delete());
		
		//����ʽ���ʽ��ѭ����Э�飬һ������û�в�����һ������û�з���ֵ ����-> {}
		//���ɵ�u2 ��һ������{}������������󷽷��ľ����ʵ�֡�
		UserMapper u2=() -> {return 2;};
		System.out.println(u2.delete());
		
		UserMapper2 u3=(user) -> {System.out.println("ִ�в������==="+user);};
		u3.insert(new User());
		
//		UserMapper2 u4=(User user) -> {};
		
		
	}
}

interface UserMapper2{
	void insert(User user); 
}

