package com.yaoxj.lambda;

import java.util.Comparator;

//@FunctionalInterface�������ע�⣬����ӿھ����ں���ʽ�ӿ�,
//������Ǻ���ʽ�ӿڣ��Ͳ�����ʹ�����ע�⣬����ᱨ��
//Runnable 	Callable Comparator ���Ǻ���ʽ�ӿ�
//jdk8 java.util.function�����涼�Ǻ���ʽ�ӿ�
//Supplier ���
//Consumer ����
//BiConsumer ��������
//Function ����һ������һ�������һ�����������ǲ�ͬ���͵ģ�
//BiFunction�����������룬һ�������һ�����������ǲ�ͬ���͵ģ�
//UnaryOperator����һ������һ�������������������ͬ���͵ģ�
//BinaryOperator�����������룬һ�������������������ͬ���͵ģ�
@FunctionalInterface
public interface UserMapper {
	
	public int delete();//����������Ǻ���ʽ�ӿ�
//	int dosave();
	//=======���������������������ڳ��󷽷�=============
	//Object�еķ���
	public  int hashCode();
	
	//Ĭ�Ϸ���
	default int save(){
		return 1;
	}
	
	//��̬����
	static int update(){
		return 2;
	}
}
