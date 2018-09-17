package com.company.concurrent;

/**
 * wait & notify
 */
public class PrintAB {

    public static void main(String[] args) {
        Object lock = new Object();

        Thread t1 = new Thread(()->{
            for(int i = 1;i <= 100;i = i+2){
                synchronized (lock){
                    try {
                        System.out.println(Thread.currentThread().getName() + " " + i);
                        lock.wait(); //释放锁
                        lock.notifyAll(); //把在这个锁上阻塞的线程唤醒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(()->{
            for(int i = 2;i <= 100;i = i+2){
                synchronized (lock){
                    try {
                        System.out.println(Thread.currentThread().getName() + " " + i);
                        lock.notifyAll();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
