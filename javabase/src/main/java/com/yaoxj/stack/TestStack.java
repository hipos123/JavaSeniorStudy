package com.yaoxj.stack;

public class TestStack {
		
	public static void myStack(){
		System.out.println("---做个递归测试----");
		myStack();
	}
	
	//当虚拟机栈小于线程请求的栈深度，就会报错
	//Exception in thread "main" java.lang.StackOverflowError
	public static void main(String[] args) {
		myStack();
	}
	
	
}
