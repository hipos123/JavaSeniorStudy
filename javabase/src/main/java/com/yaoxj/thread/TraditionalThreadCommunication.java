package com.yaoxj.thread;
//线程通讯
public class TraditionalThreadCommunication {

	public static void main(String[] args) {
		Communication commun=new Communication();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 2; i++) {
					commun.subCommun(i);
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					for (int i = 0; i < 2; i++) {
						commun.mainCommun(i);
					}
				}
			}
		}).start();

	}

}

class Communication{
	private boolean beShouldSub=true;
	public synchronized void subCommun(int i){
		while(!beShouldSub){//如果不是到子类跑的时候，就必须等待。
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int j = 0; j < 10; j++) {
			System.out.println("sub thread run:"+j+"外部循环次数:"+i);
		}
		beShouldSub=false;
		this.notify();//子类跑完之后，唤醒其他在等待的线程
	}
	
	public synchronized void mainCommun(int i){
		while(beShouldSub){//如果不是到父类在跑的时候，就必须等待。beShouldeSub=true的时候表示是子类在跑
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int j = 0; j < 10; j++) {
			System.out.println("main thread run:"+j+"外部循环次数:"+i);
		}
		beShouldSub=true;
		this.notify();
	}
}