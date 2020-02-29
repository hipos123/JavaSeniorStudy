package com.yaoxj.day1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import sun.misc.Contended;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface MyAnnotation {
//@Retention �������ע���ע�⣬Ҳ��ΪԪע�⣬Ĭ�ϵ�������ӵĻ�ע���Ǳ�����class�׶ε�
//runtime ��ʾ�Ǳ������ڴ����н׶�
//java ---->class--->�ڴ��е��ֽ���
//RetentionPolicy.SOURCE========>RetentionPolicy.CLASS------>RetentionPolicy.RUNTIME
//Դ����׶�======����׶�====�ڴ����н׶�

//=============java�ĸ�����object��class�ĸ�����type
//@Target({ElementType.METHOD,ElementType.TYPE}),������������ע��������ڷ����ϣ�Ҳ������������
	
//======�������ԣ�Ĭ�ϵ�����������value,���defalut��д������£��������ע�����Ե�ʱ�򣬾ͱ���д�����color�ı�ǩ	
	String color() ;
	String value() default "test";
	int[] mycnt();
	MetaAnnotation  metaVal();
}
