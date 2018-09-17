package com.company.concurrent.juc.CyclicBarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * using await == 0
 * 要
 */
public class CyclicBarrierExample3 {

    final int N = 3;
//    int count = 0;
    AtomicInteger count = new AtomicInteger(0);
    final int[][] matrix;
    final CyclicBarrier barrier;

    private CyclicBarrierExample3(int[][] matrix){
        this.matrix = matrix;
        barrier = new CyclicBarrier(N);
    }

    class Worker implements Runnable{

        int myRow;

        Worker(int row){
            myRow = row;
        }

        @Override
        public void run() {
            while (!done()){
                processRow(myRow);
                try {
                    int res = barrier.await();
                    if(res == 0){
                        System.out.println(Thread.currentThread().getName() + " step " + count + " ended");
                        count.getAndIncrement();
                    }else{
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean done(){
        return count.get() == 2;
    }

    private void solve() throws InterruptedException {
        List<Thread> tasks = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Thread t = new Thread(new CyclicBarrierExample3.Worker(i));
            tasks.add(t);
            t.start();
        }

        for(Thread t : tasks){
            t.join();
        }

        for(int[] row : matrix){
            for(int elem : row){
                System.out.print(elem + " ");
            }
            System.out.println();
        }
        System.out.println("job done");
    }


    private void processRow(int myRow){
        System.out.println("Thread " + Thread.currentThread().getName() + " process row " + myRow);
        int[] row = matrix[myRow];
        int rowLength = row.length;
        for (int i = 0; i < rowLength; i++) {
            matrix[myRow][i] *= 2;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] row1 = new int[]{1,2,3};
        int[] row2 = new int[]{2,3,4};
        int[] row3 = new int[]{4,5,6};
        int[][] matrix = new int[3][3];
        matrix[0] = row1;
        matrix[1] = row2;
        matrix[2] = row3;
        CyclicBarrierExample3 example = new CyclicBarrierExample3(matrix);

        example.solve();
    }
}
