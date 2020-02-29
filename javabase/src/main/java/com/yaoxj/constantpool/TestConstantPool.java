package com.yaoxj.constantpool;

public class TestConstantPool {

	//线程共享区----方法区中的常量池，方法区存储的是类信息，常量和静态常量
	//常量池也存放在方法区中，就是一个hashset，存储的是常量的地址
	
	public static void main(String[] args) {
		 String s1="abc";
		 String s2="abc";
		 System.out.println(s1==s2);
		 
		 String s3=new String("abc");
		 
		 System.out.println(s1==s3);
		 
		 System.out.println(s1==s3.intern());
	}
}
