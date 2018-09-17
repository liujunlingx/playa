package com.company.algorithm.interview;

import java.util.Scanner;

public class ByteDance2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.valueOf(scanner.nextLine());
        if (m == 0){
            System.out.println(0);
            return;
        }

        int[][] matrix = new int[m][m];
        for (int i = 0; i < m; i++) {
            String line = scanner.nextLine();
            String[] nums = line.split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.valueOf(nums[j]);
            }
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == 1){
                    dfs(matrix,i,j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static void dfs(int[][] matrix,int i,int j){
        if(matrix[i][j] == 1){
            matrix[i][j] = 0;
            //up
            if(valid(matrix,i-1,j)){
                dfs(matrix,i-1,j);
            }
            //left
            if(valid(matrix,i,j-1)){
                dfs(matrix,i,j-1);
            }
            //right
            if(valid(matrix,i,j+1)){
                dfs(matrix,i,j+1);
            }
            //down
            if(valid(matrix,i+1,j)){
                dfs(matrix,i+1,j);
            }
        }

    }

    private static boolean valid(int[][] matrix,int i,int j){
        return i >=0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }

}
