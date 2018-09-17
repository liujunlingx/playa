package com.company.algorithm.dp;

public class Find {

    public boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0 || array[0].length == 0) return false;

        int rowCount = array.length;
        int colCount = array[0].length;

        //起始i、j为左下角元素index
        int i = rowCount-1;
        int j = 0;

        while (i >= 0 && j<= colCount-1){
            if(target == array[i][j]){
                return true;
            }else if(target < array[i][j]){
                i--;
            }else{
                j++;
            }
        }
        return false;
    }
}
