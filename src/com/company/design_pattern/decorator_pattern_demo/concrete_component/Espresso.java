package com.company.design_pattern.decorator_pattern_demo.concrete_component;

import com.company.design_pattern.decorator_pattern_demo.component.Beverage;

public class Espresso extends Beverage {
    @Override
    public void getDescription() {
        System.out.println("this is espresso");
    }

    @Override
    public int getPrice() {
        return 2;
    }
}
