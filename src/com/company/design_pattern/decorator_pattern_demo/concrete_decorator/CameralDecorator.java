package com.company.design_pattern.decorator_pattern_demo.concrete_decorator;

import com.company.design_pattern.decorator_pattern_demo.component.Beverage;
import com.company.design_pattern.decorator_pattern_demo.decorator.Decorator;

public class CameralDecorator extends Decorator {

    private Beverage decorated;

    public CameralDecorator(Beverage b){
        this.decorated = b;
    }

    @Override
    public void getDescription() {
        decorated.getDescription();
    }

    @Override
    public int getPrice() {
        return decorated.getPrice() + 10;
    }
}
