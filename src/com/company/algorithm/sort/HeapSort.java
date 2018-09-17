package com.company.algorithm.sort;

public class HeapSort {

    private static int[] array = { 50, 10, 90, 30, 70, 40, 80, 60, 20 };

    private HeapSort(int[] array){
        this.array = array;
    }

    public static void main(String[] args) {
        System.out.println("排序之前：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        // 建堆
        System.out.println("\n建堆之后:");
        buildHeap();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        // 堆排序
        heapSort();
        System.out.println("\n排序之后：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * 建堆
     */
    private static void heapSort(){
        buildHeap();
        sort();
    }

    private static void sort(){
        for (int i = array.length - 1; i > 0; i--) {
            swap(0,i);
            maxHeapify(0,i);
        }
    }

    private static void buildHeap(){
        // 从第一个非叶节点开始，向前遍历到root，每个节点sift down
        int beginIndex = (array.length-2) / 2;
        for(int i = beginIndex;i >= 0;i--){
            maxHeapify(i,array.length);
        }
    }

    /**
     * 建堆
     */
    private static void maxHeapify(int index, int length){
        int leftChild = index * 2 + 1;
        int rightChild = leftChild + 1;
        if (leftChild >= length){
            return;
        }
        int maxChild = leftChild;
        if(rightChild < length){
            maxChild = array[leftChild] > array[rightChild] ? leftChild : rightChild;
        }
        if(array[index] < array[maxChild]){
            swap(index,maxChild);
            maxHeapify(maxChild,length);
        }
    }

    private static void swap(int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    private void siftUp(){

    }

    private void siftDown(){

    }
}
