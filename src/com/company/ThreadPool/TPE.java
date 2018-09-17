package com.company.ThreadPool;

import java.util.concurrent.*;

public class TPE {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,1,
                0,TimeUnit.SECONDS,new LinkedBlockingDeque<>());

        Future<?> future = executor.submit(() -> {
            Thread.sleep(3000);
            return "fuck";
        });

        while (!future.isDone()){
            System.out.println("executing");
            Thread.sleep(500);
        }

        System.out.println("after completion " + future.get());
    }
}
