package com.yaoxj.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;

public class TraditionalTimer {

	public static void main(String[] args) {
		//����֮������һ��
/*		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("bombing per 2 sencond");
			}
		}, 2000);*/
		
		//����֮������һ�Σ�����ÿ�����ٲ��ϵ�ִ��
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("bombing per 2 sencond222222");
			}
		}, 2000,3000);
		
		while(true){
			System.out.println("1 sencond:"+new Date().getSeconds());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
