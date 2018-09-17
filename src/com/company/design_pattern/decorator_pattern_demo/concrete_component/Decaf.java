package com.company.design_pattern.decorator_pattern_demo.concrete_component;

import com.company.design_pattern.decorator_pattern_demo.component.Beverage;

public class Decaf extends Beverage {
    @Override
    public void getDescription() {
        System.out.println("this is decaf");
    }

    @Override
    public int getPrice() {
        return 1;
    }
}
