package com.yaoxj.lambda;

import java.util.Comparator;

//@FunctionalInterface加上这个注解，这个接口就属于函数式接口,
//如果不是函数式接口，就不可以使用这个注解，否则会报错
//Runnable 	Callable Comparator 就是函数式接口
//jdk8 java.util.function包下面都是函数式接口
//Supplier 输出
//Consumer 输入
//BiConsumer 两个输入
//Function 代表一个输入一个输出（一般输入和输出是不同类型的）
//BiFunction代表两个输入，一个输出（一般输入和输出是不同类型的）
//UnaryOperator代表一个输入一个输出（输入和输出是相同类型的）
//BinaryOperator代表两个输入，一个输出（输入和输出是相同类型的）
@FunctionalInterface
public interface UserMapper {
	
	public int delete();//加上这个就是函数式接口
//	int dosave();
	//=======以下这三个方法都不属于抽象方法=============
	//Object中的方法
	public  int hashCode();
	
	//默认方法
	default int save(){
		return 1;
	}
	
	//静态方法
	static int update(){
		return 2;
	}
}
