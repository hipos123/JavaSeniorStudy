package com.yaoxj.day1;


@MyAnnotation(color="blue",mycnt={1,2,3},metaVal=@MetaAnnotation(value="6666",name="yaoxj"))
public class AnnotationTest extends Object{

	//@SuppressWarnings("deprecation") ���ע���ڸ��߱������ڱ����ʱ��������ʱ�ķ�����������ʾ��
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
 
	//@Deprecated  ���߱�����������һ����ʱ�ķ���
	@Deprecated
	public static void SayHello(){
		System.out.println("hi,����һ����ʱ�ķ��������治Ҫ��������");
	}
	
//	@Override  ���Ǹ���ķ���������������ע�⣬�������������һ���µķ���
//	public String toStirng(){
//		return null;
//		
//	}

}
