package com.company.concurrent.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 可以控制对互斥资源的访问线程数。
 */
public class SemaphoreExample {

    //每次只能有 3 个客户端同时访问，请求总数为 10。
    public static void main(String[] args) throws InterruptedException {
        int clientCount = 3;
        int total = 10;
        Semaphore semaphore = new Semaphore(clientCount);
        System.out.println(semaphore.availablePermits());
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < total; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " enters, available " +
                            semaphore.availablePermits());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }
        executorService.shutdown();
    }
}
