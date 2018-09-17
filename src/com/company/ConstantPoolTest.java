package com.company;

public class ConstantPoolTest {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = new String("xyz").intern();
        String s3 = "def" + "opq";
    }
}
