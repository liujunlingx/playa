package com.company.algorithm.sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {80,30,60,20,10,60,50,70};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array);
        for(int i : array){
            System.out.println(i);
        }
    }

    private void sort(int[] array){
        quickSort(array,0,array.length);
    }

    private void quickSort(int[] array,int left,int right){
        if(left >= right - 1){
            return;
        }
        int pivot = array[left];
        int i = left;
        for (int j = i+1; j < right; j++) {
            if(array[j] < pivot){
                i++;
                swap(array,i,j);
            }
        }
        swap(array,left,i);
        quickSort(array,left,i);
        quickSort(array,i+1,right);
    }

    private void swap(int[] array,int a,int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
