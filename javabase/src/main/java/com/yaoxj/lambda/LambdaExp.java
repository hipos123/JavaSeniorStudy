package com.yaoxj.lambda;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;


//lambda ����ʽ,��������
public class LambdaExp {
	
	public static String getSmt(){
		return "��̬��������";
	}
	
	public  String getInst(){
		return "ʵ����������";
	}
	public static void getConsumer(Integer size){
		System.out.println("������������������������С�ǣ�"+size);
	}
	public static void main(String[] args) {
		Runnable r =() -> {System.out.println("�����߳�");};
		r.run();
		
		//��̬�������ã��������ʽ�ӿ���ͨ�����þ�̬����ʵ�ֵģ��Ϳ��Ը�дΪ����::������
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
		
		//ʵ���������ã��������ʽ�ӿ���ͨ������ʵ������ʵ�ֵģ��Ϳ��Ը�дΪʵ��::������
		Supplier<String> s4=new LambdaExp()::getInst;
		System.out.println(s4.get());
		
		//���󷽷����ã���һ�������������õĶ��󣬺�����Ǹ������ͷ����Ĳ���һ�µ�����£�����ʹ�ö��󷽷�����
		
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
		
		//���췽�����ã��������ʽ�ӿڵ�ʵ��������һ����Ҫһ�����캯����ʵ�֣���ô�Ϳ���ֱ��ʹ�ù��췽������
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
		System.out.println("��������һ�����캯��");
	}
	public Person(String name){
		System.out.println("��������һ�����캯����"+name);
	}
}