package com.yaoxj.thread;
//�߳�ͨѶ
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
		while(!beShouldSub){//������ǵ������ܵ�ʱ�򣬾ͱ���ȴ���
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int j = 0; j < 10; j++) {
			System.out.println("sub thread run:"+j+"�ⲿѭ������:"+i);
		}
		beShouldSub=false;
		this.notify();//��������֮�󣬻��������ڵȴ����߳�
	}
	
	public synchronized void mainCommun(int i){
		while(beShouldSub){//������ǵ��������ܵ�ʱ�򣬾ͱ���ȴ���beShouldeSub=true��ʱ���ʾ����������
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int j = 0; j < 10; j++) {
			System.out.println("main thread run:"+j+"�ⲿѭ������:"+i);
		}
		beShouldSub=true;
		this.notify();
	}
}