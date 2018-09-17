package com.company.design_pattern.observer_pattern_demo;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = Integer.valueOf(scanner.nextLine());
//        String[] points = new String[n];
//        for (int i = 0; i < n; i++) {
//            points[i] = scanner.nextLine();
//        }
//        Integer[] x = new Integer[n];
//        Integer[] y = new Integer[n];
//        for (int i = 0; i < n; i++) {
//            String[] xy = points[i].split(",");
//            x[i] = Integer.valueOf(xy[0]);
//            y[i] = Integer.valueOf(xy[1]);
//        }
//        System.out.println(calculate(x, y));

        List<Integer> list = new ArrayList<>();
        int n = 3;
        for (int i = 1; i < n + 1; i++) {
            list.add(i);
        }
        List<List<Integer>> allPaths = getPerm(list);
    }

    static int calculate(Integer[] x, Integer[] y) {
        int num = x.length;
        int[][] dist = new int[num + 1][num];//n个点+原点，共n+1个点
        //所有点两两之间的距离
        for (int i = 0; i < num + 1; i++) {
            for (int j = 0; j < num; j++) {
                if (i == 0) //原点到所有点的距离，加法表示只能按坐标轴走，不能斜着走
                    dist[i][j] = Math.abs(x[j]) + Math.abs(y[j]);
                else
                    dist[i][j] = Math.abs(x[j] - x[i-1]) + Math.abs(y[j] - y[i-1]);

            }
        }
        List<Integer> list = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            list.add(i);
        }
        List<List<Integer>> allPaths = getPerm(list);

        //暴力搜
        int globalMin = -1;
        for(List<Integer> onePath : allPaths){
            int localMin = 0;

            int fromNode = 0;
            int toNode;

            for (int i = 0; i < num; i++) {
                toNode = onePath.get(i);
                if(i == 0){
                    localMin += dist[fromNode][toNode];
                }else {
                    localMin += dist[fromNode+1][toNode];
                }
                fromNode = toNode;
            }

            localMin += dist[0][fromNode];

            if(globalMin == -1){
                globalMin = localMin;
            }
            if(localMin < globalMin)
                globalMin = localMin;
        }
        return globalMin;
    }

    //给定一个list，产生全排列，比如给定[1,2,3],产生6组123、132、213、231、312、321
    static  <E> List<List<E>> generatePerm(List<E> original) {
        if (original.size() == 0) {
            List<List<E>> result = new ArrayList<List<E>>();
            result.add(new ArrayList<E>());
            return result;
        }
        E firstElement = original.remove(0);
        List<List<E>> returnValue = new ArrayList<List<E>>();
        List<List<E>> permutations = generatePerm(original);
        for (List<E> smallerPermutated : permutations) {
            for (int index=0; index <= smallerPermutated.size(); index++) {
                List<E> temp = new ArrayList<E>(smallerPermutated);
                temp.add(index, firstElement);
                returnValue.add(temp);
            }
        }
        return returnValue;
    }

    static <E> List<List<E>> getPerm(List<E> original){
        List<E> originalCopy = new ArrayList<>(original);

        if(original.size() == 0){
            List<List<E>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        E firstElement = originalCopy.remove(0);

        List<List<E>> result = new ArrayList<>();
        List<List<E>> subPermutations = getPerm(originalCopy);
        for(List<E> subPermutation : subPermutations){
            for(int index = 0; index < originalCopy.size() + 1;index++){
                List<E> subPermutationCopy = new ArrayList<>(subPermutation);
                subPermutationCopy.add(index,firstElement);
                result.add(subPermutationCopy);
            }
        }

        return result;
    }


}
