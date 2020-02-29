package com.yaoxj.thread;

//�̻߳��⣬��ν�̻߳��⣬����һ��é�ӣ�ֻ���˶����֮����һ���˲ſ��Խ�����
public class TraditionalThreadSynchorized {

	public static void main(String[] args) {
		init();
	}
	
	private static void init() {
		final Outputer output=new Outputer();
		//-------------begin-------------------
		//���ַ�ʽ��������У��̻߳ụ�ྺ�������������ݻ��в�׼ȷ
		/*new Thread(new Runnable() {
			public void run() {
				while(true){
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					output.output("yaoxj");
				}
			
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				while(true){
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					output.output("hangsome man");
				}
			}
		}).start();*/
		
		//-------------------------end-----------------
		
		//--------------begin---------------------
		new Thread(new Runnable() {
			public void run() {
				while(true){
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					output.output4("yaoxj");
				}
			
			}
		}).start();
		
		
		new Thread(new Runnable() {
			public void run() {
				while(true){
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					output.output4("hangsome man");
				}
			}
		}).start();
		
	}

}
class Outputer{
	public void output(String name){
		int len=name.length();
		for (int i = 0; i < len; i++) {
			System.out.print(name.charAt(i));
		}
		System.out.println();
	}
	
	public void output2(String name){
		//-------synchronized��һ�������Ͻ�����δ���Ļ��⡣����nameÿ���ǲ�һ���ģ������������Ľ��Ҳ���������ġ�
		synchronized(name){
			int len=name.length();
			for (int i = 0; i < len; i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
	}
	
	//����һ����������ԵĶ�������������л��⣬ֻ������̵߳���δ���ִ�����֮�󣬿��زŹرյ�����������һ���߳̽���ִ�С�
	//����mykey����ͬһ��������������ǿ��Ի����
	public void output3(String name){
		String mykey="";
		synchronized(mykey){
			int len=name.length();
			for (int i = 0; i < len; i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
	}
	
	//������ؼ�����ȡ�������ϣ���ʾ��������ǻ���ģ�ֻ���������������֮�󣬲�������һ���߳�ִ��
	//����output��ͬһ�����������̻߳ụ��
	public synchronized void output4(String name){
		String mykey="";
			int len=name.length();
			for (int i = 0; i < len; i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
	}
	
	//������ͬһ���ֽ��룬Ҳ�ǻ����
	public void output5(String name){
		synchronized(TraditionalThreadSynchorized.class){
			int len=name.length();
			for (int i = 0; i < len; i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
	}
}
