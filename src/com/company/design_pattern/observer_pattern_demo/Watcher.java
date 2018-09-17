package com.company.design_pattern.observer_pattern_demo;

import java.util.Observable;

public class Watcher implements java.util.Observer
{
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(this.hashCode() + " update called, count is " + ((Integer)arg).intValue());
    }
}
