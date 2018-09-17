package com.company.algorithm.interview;

public class JDChoose3 {

    private static int x = 10;
    private static Integer y = 10;

    private static void updateX(int value){
        value = value * 3;
    }

    private static void updateY(Integer value){
        value = value * 3;
    }

    public static void main(String[] args) {
        updateX(x);
        updateY(y);

        System.out.println(x);
        System.out.println(y);
    }
}
