package com.company.algorithm.interview;

public class JDChoose4 {

    public static void main(String[] args) {
        System.out.println(B1.c);
    }
}

class A1{
    public static String c = "C";
    static {
        System.out.println("A1");
    }
}

class B1 extends A1{
    static {
        System.out.println("B1");
    }
}
