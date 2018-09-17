package com.company.algorithm.interview;

import java.util.Scanner;

public class Tencent1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] words = scanner.nextLine().split(" ");
            int A = Integer.valueOf(words[0]);
            int B = Integer.valueOf(words[1]);
            int C = Integer.valueOf(words[2]);

            if(func(A,B,C)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    public static boolean func(int A,int B,int C){
        boolean yes = false;

        if (C == 0 ){

            if( A % B == 0){
                yes = true;
                return yes;
            }

        }

        if (A % B == 0){
            yes = false;
            return yes;
        }

        int remaining = A % B;
        int count = 1;
        int value ;

        if (remaining == C){
            yes = true;
            return yes;
        }

        if (remaining % 2 == 0 && (B + C) % 2 == 0){
            yes = true;
            return yes;
        }

        if (remaining % 2 == 1 && (B + C) % 2 == 1){
            yes = true;
            return yes;
        }

        return yes;
    }
}

//        3
//        91 16 5
//        58 16 0
//        96 12 4
