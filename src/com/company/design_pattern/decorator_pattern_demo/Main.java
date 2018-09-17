package com.company.design_pattern.decorator_pattern_demo;

import com.company.design_pattern.decorator_pattern_demo.component.Beverage;
import com.company.design_pattern.decorator_pattern_demo.concrete_component.Decaf;
import com.company.design_pattern.decorator_pattern_demo.concrete_component.Espresso;
import com.company.design_pattern.decorator_pattern_demo.concrete_decorator.CameralDecorator;
import com.company.design_pattern.decorator_pattern_demo.concrete_decorator.SoyDecorator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Beverage decaf = new Decaf();
        Beverage espresso = new Espresso();

        Beverage decafWithCameral = new CameralDecorator(decaf);
        Beverage espressoWithCameralAndSoy = new SoyDecorator(new CameralDecorator(espresso));

        System.out.println(decaf.getPrice());
        System.out.println(espresso.getPrice());
        System.out.println(decafWithCameral.getPrice());
        System.out.println(espressoWithCameralAndSoy.getPrice());

        Main main = new Main();
    }

}

