package com.yaoxj.day1;


@MyAnnotation(color="blue",mycnt={1,2,3},metaVal=@MetaAnnotation(value="6666",name="yaoxj"))
public class AnnotationTest extends Object{

	//@SuppressWarnings("deprecation") 这个注解在告诉编译器在编译的时候遇到过时的方法，不做提示。
	//
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.runFinalizersOnExit(true);
//		SayHello();
		if(AnnotationTest.class.isAnnotationPresent(MyAnnotation.class)){
			MyAnnotation myAnnotation=(MyAnnotation)AnnotationTest.class.getAnnotation(MyAnnotation.class);
			System.out.println(myAnnotation);
			System.out.println(myAnnotation.color());
			System.out.println(myAnnotation.value());
			System.out.println(myAnnotation.mycnt().length);
			System.out.println(myAnnotation.metaVal().value());
		}
	}
 
	//@Deprecated  告诉编译器，我是一个过时的方法
	@Deprecated
	public static void SayHello(){
		System.out.println("hi,我是一个过时的方法，后面不要调用我了");
	}
	
//	@Override  覆盖父类的方法，如果不加这个注解，代表的是重载了一个新的方法
//	public String toStirng(){
//		return null;
//		
//	}

}
