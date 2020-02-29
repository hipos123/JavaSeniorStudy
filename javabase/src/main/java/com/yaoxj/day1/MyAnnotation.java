package com.yaoxj.day1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import sun.misc.Contended;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface MyAnnotation {
//@Retention 代表的是注解的注解，也称为元注解，默认的如果不加的话注解是保留在class阶段的
//runtime 表示是保留在内存运行阶段
//java ---->class--->内存中的字节码
//RetentionPolicy.SOURCE========>RetentionPolicy.CLASS------>RetentionPolicy.RUNTIME
//源代码阶段======编译阶段====内存运行阶段

//=============java的父类是object，class的父类是type
//@Target({ElementType.METHOD,ElementType.TYPE}),这个代表了这个注解可以用在方法上，也可以用在类上
	
//======新增属性，默认的属性名称是value,如果defalut不写的情况下，调用这个注解属性的时候，就必须写上这个color的标签	
	String color() ;
	String value() default "test";
	int[] mycnt();
	MetaAnnotation  metaVal();
}
