package com.yaoxj.constantpool;

public class TestConstantPool {

	//�̹߳�����----�������еĳ����أ��������洢��������Ϣ�������;�̬����
	//������Ҳ����ڷ������У�����һ��hashset���洢���ǳ����ĵ�ַ
	
	public static void main(String[] args) {
		 String s1="abc";
		 String s2="abc";
		 System.out.println(s1==s2);
		 
		 String s3=new String("abc");
		 
		 System.out.println(s1==s3);
		 
		 System.out.println(s1==s3.intern());
	}
}
