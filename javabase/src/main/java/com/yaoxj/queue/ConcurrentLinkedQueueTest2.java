package com.yaoxj.queue;

import java.util.Iterator;
import java.util.concurrent.*;

/**
 * @description:
 * @author: yaoxj
 * @create: 2020-07-01 16:56
 **/
public class ConcurrentLinkedQueueTest2 {
   static ConcurrentLinkedQueue concurrentLinkedQueue=new ConcurrentLinkedQueue();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(() ->{
            try {
                for (int i=0;i<10;i++){
                    concurrentLinkedQueue.add(Thread.currentThread().getName()+"&&&"+i);
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
        Iterator iterator = concurrentLinkedQueue.iterator();
        while (iterator.hasNext()){
            String next = (String) iterator.next();
            System.out.println("看看能不能跑到这边"+next);
        }

    }
}
