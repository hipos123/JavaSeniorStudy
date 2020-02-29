package com.yaoxj.lambda;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;


//lambda 表达式,方法引用
public class LambdaExp {
	
	public static String getSmt(){
		return "静态方法引用";
	}
	
	public  String getInst(){
		return "实例方法引用";
	}
	public static void getConsumer(Integer size){
		System.out.println("有输入参数，无输出参数，大小是："+size);
	}
	public static void main(String[] args) {
		Runnable r =() -> {System.out.println("启动线程");};
		r.run();
		
		//静态方法引用：如果函数式接口是通过调用静态方法实现的，就可以改写为类名::方法名
		Supplier<String> s=() -> {return "hello";};
		System.out.println(s.get());
		
		Supplier<String> s3=() -> LambdaExp.getSmt();
		System.out.println(s3.get());
		
		Supplier<String> s2=LambdaExp::getSmt;
		System.out.println(s2.get());
		
		Consumer<Integer> c=(size) -> LambdaExp.getConsumer(size);
		Consumer<Integer> c2=LambdaExp::getConsumer;
		c.accept(11);
		c2.accept(30);
		
		//实例方法引用：如果函数式接口是通过调用实例方法实现的，就可以改写为实例::方法名
		Supplier<String> s4=new LambdaExp()::getInst;
		System.out.println(s4.get());
		
		//对象方法引用：第一个参数就是引用的对象，后面的那个参数和方法的参数一致的情况下，可以使用对象方法引用
		
//		Function<Teacher,String> f=(tch) -> {new };
//		Teacher aa=new Teacher();
		
		Consumer<Teacher> c3=(tch) -> {new Teacher().getname();};
		Consumer<Teacher> c4=Teacher::getname;
		
		BiConsumer<Teacher,String> c1=(tch,str) -> {new Teacher().getTeacherSex(str);};
		BiConsumer<Teacher,String> bc=Teacher::getTeacherSex;
		
		c4.accept(new Teacher());
		bc.accept(new Teacher(), "ABy");
		
//		c1.accept(new Teacher(), "ABy");
//		c3.accept(new Teacher());
		
		//构造方法引用：如果函数式接口的实现正好是一个需要一个构造函数来实现，那么就可以直接使用构造方法引用
		Supplier<Person> sp=() -> new Person();
		sp.get();
		Supplier<Person> sp2=Person::new;
		sp2.get();
		
		Consumer<String> sp3=(str) -> new Person(str);
		sp3.accept("bigbb");
		
		Consumer<String> sp4=Person::new;
		sp4.accept("bigbb@@@@@@");
		
		
	}

}
 class Teacher{
	 public void getname(){
		 System.out.println("my name you baba==");
	 }
	public String getTeacherSex(String name){
		System.out.println("name=="+name+":sex=="+name.charAt(1));
		return name;
	}
}
 
class Person{
	public Person(){
		System.out.println("我来构造一个构造函数");
	}
	public Person(String name){
		System.out.println("我来构造一个构造函数："+name);
	}
}
