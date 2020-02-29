package com.yaoxj.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreLearn {   
//	�ź�������   
	private static final int SEM_MAX = 12;  
	public static void main(String[] args) {      
		Semaphore sem = new Semaphore(SEM_MAX);    
		//�����̳߳�    
		ExecutorService threadPool = Executors.newFixedThreadPool(3);    
		//���̳߳���ִ������     
		threadPool.execute(new MyThread(sem, 7));     
		threadPool.execute(new MyThread(sem, 8));    
		threadPool.execute(new MyThread(sem, 2));     
		//�رճ�     
		threadPool.shutdown();  
	}
}   
     class MyThread extends Thread {    
    	 private volatile Semaphore sem;  
    	 // �ź���   
    	 private int count;    
    	 // �����ź����Ĵ�С           
    	 MyThread(Semaphore sem, int count) {      
    		 this.sem = sem;      
    		 this.count = count;     
    		 
    	 }    
    	 public void run() {  
    		 try {        
    			 // ���ź����л�ȡcount�����        
    			 sem.acquire(count);         
    			 Thread.sleep(2000);         
    			 System.out.println(Thread.currentThread().getName() + " acquire count="+count);      
    			 } catch (InterruptedException e) { 
    				 e.printStackTrace();     
    			} finally {    
    					 // �ͷŸ�����Ŀ����ɣ����䷵�ص��ź�����        
    				sem.release(count);  
    				System.out.println(Thread.currentThread().getName() + " release " + count + "");
    			}     
    		 }   
	}


