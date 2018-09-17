package com.company.concurrent.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private ReentrantLock lock = new ReentrantLock();
    private Condition emptyCondition = lock.newCondition();
    private Condition fullCondition = lock.newCondition();
    private Integer capacity = 5;
    private List<Integer> queue = new ArrayList<>();
    private AtomicInteger index = new AtomicInteger(0);

    public static void main(String[] args) {
        ReentrantLockExample lockExample = new ReentrantLockExample();

        Thread producer = new Thread(()->{
            while (true){
                lockExample.lock.lock();
                try{
//                    if(lockExample.queue.size() == lockExample.capacity){
//                        System.out.println("producer wait");
//                        lockExample.fullCondition.await();
//                    }
//                    System.out.println("produced " + lockExample.index.get());
//                    lockExample.queue.add(lockExample.index.getAndIncrement());
                    lockExample.emptyCondition.signal();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
                } finally {
                    lockExample.lock.unlock();
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        });

        Thread consumer = new Thread(()->{
            while (true){
                lockExample.lock.lock();
                try{
                    while(lockExample.queue.isEmpty()){
                        System.out.println("consumer wait");
                        lockExample.emptyCondition.await();
                    }
                    Integer product = lockExample.queue.remove(0);
                    System.out.println("Consumed " + product);
                    lockExample.fullCondition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lockExample.lock.unlock();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        consumer.start();
        producer.start();

    }
}
