package com.yaoxj.day2;

public class EnglishPerson implements PersonInterface {

	@Override
	public void eatFun() {
		System.out.println("使用刀叉吃饭");
	}

	@Override
	public String myskin(String skin) {
		System.out.println("英国人的皮肤是"+skin);
		return skin;
	}

}
