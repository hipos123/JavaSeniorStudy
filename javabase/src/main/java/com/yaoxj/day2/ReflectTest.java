package com.yaoxj.day2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

	public static void main(String[] args) throws Exception {
		
		//isPrimitive���ж�һ��class�Ƿ���ԭʼ���ͣ� 
		//�Ƿ��ǻ��������ֽ��롣int��float��double��boolean��byte��short��char��long��void
		//�����ڻ��������ֽ���
//		System.out.println(int.class.isPrimitive());
		
		//���ǾͲ����ڻ��������ֽ��룬������
//		System.out.println(String.class.isPrimitive());
//		System.out.println(Integer.class.isPrimitive());
		
		//���������Ӵ����������Double.TYPE.....
//		System.out.println(Integer.TYPE.isPrimitive());
		
		//===============ͨ�����·�ʽ����ȡClass����ʵ��
//		String abc="yaxj";
//		System.out.println(abc.getClass());
//		System.out.println(String.class);
//		System.out.println(Class.forName("java.lang.String"));
		
		//Java�ķ���������ڱ��벢��ȷ�����ĸ��౻�����ˣ�
		//�����ڳ������е�ʱ��ż��ء�֪̽������ʹ���ڱ����ڲ���֪�����ࡣ�������ص���Ƿ��䡣
		Class clz=Class.forName("com.yaoxj.day2.ChinaPerson");
		try {
			
		  Method[] method=clz.getDeclaredMethods();//���õõ���Class��������󣬷��ط������󼯺�  
           
		  Method m=clz.getDeclaredMethod("eatFun");
		  m.invoke(clz.newInstance());
		  
		  Method m2=clz.getDeclaredMethod("myskin",String.class);
		  m2.invoke(clz.newInstance(),"ttt");
		  
		  Method m3=clz.getDeclaredMethod("test");
		  m3.invoke(clz.newInstance());
	           
//			PersonInterface pers=(PersonInterface) clz.newInstance();
//			pers.eatFun();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
