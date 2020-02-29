package com.yaoxj.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;

public class TraditionalTimer {

	public static void main(String[] args) {
		//两秒之后运行一次
/*		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("bombing per 2 sencond");
			}
		}, 2000);*/
		
		//两秒之后运行一次，接着每三秒再不断的执行
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
