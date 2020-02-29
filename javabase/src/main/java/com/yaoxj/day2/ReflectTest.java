package com.yaoxj.day2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

	public static void main(String[] args) throws Exception {
		
		//isPrimitive（判断一个class是否是原始类型） 
		//是否是基础类型字节码。int，float，double，boolean，byte，short，char，long，void
		//都属于基本类型字节码
//		System.out.println(int.class.isPrimitive());
		
		//他们就不属于基本类型字节码，都是类
//		System.out.println(String.class.isPrimitive());
//		System.out.println(Integer.class.isPrimitive());
		
		//可以这样子代表基本类型Double.TYPE.....
//		System.out.println(Integer.TYPE.isPrimitive());
		
		//===============通过以下方式，获取Class对象实例
//		String abc="yaxj";
//		System.out.println(abc.getClass());
//		System.out.println(String.class);
//		System.out.println(Class.forName("java.lang.String"));
		
		//Java的反射机制是在编译并不确定是哪个类被加载了，
		//而是在程序运行的时候才加载、探知、自审。使用在编译期并不知道的类。这样的特点就是反射。
		Class clz=Class.forName("com.yaoxj.day2.ChinaPerson");
		try {
			
		  Method[] method=clz.getDeclaredMethods();//利用得到的Class对象的自审，返回方法对象集合  
           
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
