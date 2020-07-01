package com.yaoxj.queue;

import java.util.concurrent.*;

/**
 * @description:
 * @author: yaoxj
 * @create: 2020-07-01 17:26
 **/
public class ConcurrentLinkedQueueTest {
    public static void main(String[] args) {
        int element = 1;
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();

        Runnable offerTask = () -> queue.offer(element);

        Callable<Integer> pollTask = () -> {
            while (queue.peek() != null) {
                return queue.poll().intValue();
            }
            return null;
        };

        executorService.submit(offerTask);
        Future<Integer> returnedElement = executorService.submit(pollTask);
        try {
            System.out.println(returnedElement.get().intValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
//        assertThat(returnedElement.get().intValue(), is(equalTo(element)));
    }
}
