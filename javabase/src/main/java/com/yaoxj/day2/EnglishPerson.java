package com.yaoxj.day2;

public class EnglishPerson implements PersonInterface {

	@Override
	public void eatFun() {
		System.out.println("ʹ�õ���Է�");
	}

	@Override
	public String myskin(String skin) {
		System.out.println("Ӣ���˵�Ƥ����"+skin);
		return skin;
	}

}
