package com.yaoxj.stringbuffer;

public class StringBufferTest {

	public static void main(String[] args) {
		String ret="";
		String ret2="";
		long begin = System.currentTimeMillis(); 
		for (int i = 0; i < 100; i++) {
			ret+=i;
		}
		System.out.println(ret);
		long over = System.currentTimeMillis(); 
		System.out.println(" �����ַ������������������ʹ�õ�ʱ��Ϊ�� " + (over - begin) + " ���� " ); 
		
		
		long begin2 = System.currentTimeMillis(); 
		StringBuilder sbf=new  StringBuilder();
		for (int i = 0; i < 100; i++) {
			sbf.append(i);
		}
		ret2=sbf.toString();
		System.out.println(ret2);
		long over2 = System.currentTimeMillis(); 
		System.out.println(" StringBuilder�� " + (over2 - begin2) + " ���� " );
	}

}
