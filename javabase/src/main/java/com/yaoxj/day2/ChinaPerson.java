package com.yaoxj.day2;

public class ChinaPerson implements PersonInterface {

	@Override
	public void eatFun() {
		System.out.println("ʹ�ÿ��ӳԷ�");
		
	}
	@Override
	public String myskin(String skin) {
		System.out.println("�й��˵�Ƥ����"+skin);
		return skin;
	}
	
	public void test(){
		System.out.println("���Լ��Զ���һ������");
	}

}
