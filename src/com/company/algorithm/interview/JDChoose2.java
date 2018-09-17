package com.company.algorithm.interview;

public class JDChoose2 {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class clazz = loader.loadClass("com.company.algorithm.interview.A");
        System.out.println("Test");
        clazz.forName("com.company.algorithm.interview.A");
    }
}

class A{
    static {
        System.out.println("A");
    }
}
