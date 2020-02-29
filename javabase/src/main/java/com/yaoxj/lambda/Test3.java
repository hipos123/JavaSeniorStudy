package com.yaoxj.lambda;

import java.util.concurrent.Callable;

public class Test3 {

	public static void main(String[] args) throws Exception {
		Runnable r=new Runnable() {
			@Override
			public void run() {
				System.out.println("无参函数式接口，无返回值");
			}
		};
		r.run();
		
		Runnable r1= () -> {System.out.println("r1无参函数式接口，无返回值");};
		
		
		//简单的函数体，都不需要{}
		Runnable r2= () -> System.out.println("r2无参函数式接口，无返回值");
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
		//逻辑非常简单，不需要return
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
		
		//函数式表达式遵循两个协议，一个是有没有参数，一个是有没有返回值 （）-> {}
		//生成的u2 是一个对象，{}里面是这个对象方法的具体的实现。
		UserMapper u2=() -> {return 2;};
		System.out.println(u2.delete());
		
		UserMapper2 u3=(user) -> {System.out.println("执行插入操作==="+user);};
		u3.insert(new User());
		
//		UserMapper2 u4=(User user) -> {};
		
		
	}
}

interface UserMapper2{
	void insert(User user); 
}

