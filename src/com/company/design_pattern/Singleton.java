package com.company.design_pattern;

/**
 * 单例双重锁，加volatile保证线程安全
 */
public class Singleton {

    private static volatile Singleton instance;

    public Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
