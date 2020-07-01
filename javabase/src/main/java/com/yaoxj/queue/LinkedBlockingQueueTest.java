package com.yaoxj.queue;

import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @description:
 * @author: yaoxj
 * @create: 2020-07-01 16:56
 **/
public class LinkedBlockingQueueTest {
   static  LinkedBlockingQueue linkedBlockingQueue=new LinkedBlockingQueue();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        ExecutorService executorService2 = Executors.newFixedThreadPool(1);

/*        executorService.submit(() ->{
            Iterator iterator = linkedBlockingQueue.iterator();
            while (iterator.hasNext()){
                String next = (String) iterator.next();
                System.out.println("看看能不能跑到这边"+next);
            }
        });*/


        executorService2.submit(() ->{
            try {
                for (int i=0;i<10;i++){
                    linkedBlockingQueue.add(Thread.currentThread().getName()+"&&&"+i);
//                    System.out.println("先放进去数据");
//                    Thread.sleep(1000);
                }
                getdata();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }

    private static void getdata(){

        Iterator iterator = linkedBlockingQueue.iterator();
        while (iterator.hasNext()){
            String next = (String) iterator.next();
            System.out.println("看看能不能跑到这边"+next);
        }

/*        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(() ->{
            Iterator iterator = linkedBlockingQueue.iterator();
            while (iterator.hasNext()){
                String next = (String) iterator.next();
                System.out.println("看看能不能跑到这边"+next);
            }
        });*/
    }
}
