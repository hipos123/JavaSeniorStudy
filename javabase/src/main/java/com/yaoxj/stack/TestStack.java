package com.yaoxj.stack;

public class TestStack {
		
	public static void myStack(){
		System.out.println("---�����ݹ����----");
		myStack();
	}
	
	//�������ջС���߳������ջ��ȣ��ͻᱨ��
	//Exception in thread "main" java.lang.StackOverflowError
	public static void main(String[] args) {
		myStack();
	}
	
	
}
