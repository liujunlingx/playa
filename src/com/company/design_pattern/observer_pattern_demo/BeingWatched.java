package com.company.design_pattern.observer_pattern_demo;

import java.util.Observable;

public class BeingWatched extends Observable {

    void countDown(int period){
        for(;period > 0;period--){
            setChanged();
            notifyObservers(new Integer(period));
            try {
                Thread.sleep(100);
            } catch( InterruptedException e) {
                System.out.println("Sleep interrupeted" );
            }
        }
    }

    public static void main(String[] args) {
        BeingWatched beingWatched = new BeingWatched();//被观察者
        Watcher watcher1 = new Watcher();//观察者
        Watcher watcher2 = new Watcher();//观察者
        beingWatched.addObserver(watcher1);
        beingWatched.addObserver(watcher2);

        beingWatched.countDown(10);
    }
}
