package com.company.algorithm.sort;

public class MergeSort {

    private int[] temp;

    public static void main(String[] args) {
        int[] array = {80,30,60,20,10,60,50,70};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array);
        for(int i : array){
            System.out.println(i);
        }
    }

    private void sort(int[] array){
        temp = new int[array.length];
        sort(array,0,array.length);
    }

    /**
     *
     * @param array
     * @param left inclusive
     * @param right exclusive
     * @return
     */
    private void sort(int[] array,int left,int right){
        if(left == right - 1){
            return;
        }
        int middle = left + (right - left)/2;
        sort(array,left,middle);
        sort(array,middle,right);
        merge(array,left,middle,right);
    }

    private void merge(int[] array,int left,int middle,int right){
        for (int i = left; i < right; i++) {
            temp[i] = array[i];
        }
        int i = left;
        int j = middle;
        int k = left;
        while (i < middle && j < right){
            if(temp[i] < temp[j]){
                array[k] = temp[i];
                i++;
            }else{
                array[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i < middle){
            array[k] = temp[i];
            i++;
        }
        while (j < right){
            array[k] = temp[j];
            j++;
        }
    }

    private void swap(int[] array,int a,int b){
        int temp = a;
        array[a] = b;
        array[b] = temp;
    }
}
