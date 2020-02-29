package com.yaoxj.day2;

public class ChinaPerson implements PersonInterface {

	@Override
	public void eatFun() {
		System.out.println("使用筷子吃饭");
		
	}
	@Override
	public String myskin(String skin) {
		System.out.println("中国人的皮肤是"+skin);
		return skin;
	}
	
	public void test(){
		System.out.println("我自己自定义一个方法");
	}

}
