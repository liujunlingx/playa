package com.company.algorithm.interview;

import java.util.HashSet;
import java.util.Scanner;

public class JD2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            String[] nums = scanner.nextLine().split(" ");
            a[i] = Integer.valueOf(nums[0]);
            b[i] = Integer.valueOf(nums[1]);
            c[i] = Integer.valueOf(nums[2]);
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j == i){
                    continue;
                }
                if(a[j] > a[i] && b[j] > b[i] && c[j] > c[i]){
                    set.add(i);
                }
            }
        }
        System.out.println(set.size());
    }
}
