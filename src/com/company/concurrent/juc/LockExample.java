package com.company.concurrent.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

    private ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        LockExample lockExample = new LockExample();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()->{
            lockExample.fun();});
        executorService.execute(()->{
            lockExample.fun();});

    }

    public void fun(){
        try{
            lock.lock();
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        }finally {
            lock.unlock();
        }
    }

}
