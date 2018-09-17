package com.company.algorithm.interview;

public class JDChoose1 {

    public static void main(String[] args) {
        System.out.println("A");
        new JDChoose1();
        new JDChoose1();
    }

    public JDChoose1(){
        System.out.println("B");
    }

    {
        System.out.println("C");
    }

    static {
        System.out.println("D");
    }
}
