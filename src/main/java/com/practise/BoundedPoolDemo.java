package com.practise;

import java.util.concurrent.*;

public class BoundedPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService abortPolicyExecutor = new ThreadPoolExecutor(
            2,
                2,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                new ThreadPoolExecutor.AbortPolicy());
        
        ExecutorService callerRunExecutor = new ThreadPoolExecutor(
                2,
                2,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                new ThreadPoolExecutor.CallerRunsPolicy());
        
        abortPolicy(abortPolicyExecutor);
    System.out.println("=======================================================");
        callerPolicy(callerRunExecutor);

        abortPolicyExecutor.shutdown();
        abortPolicyExecutor.awaitTermination(10,TimeUnit.SECONDS);
        abortPolicyExecutor.shutdownNow();

        callerRunExecutor.shutdown();
        callerRunExecutor.awaitTermination(10,TimeUnit.SECONDS);
        callerRunExecutor.shutdownNow();
    }

    private static void callerPolicy(ExecutorService callerRunExecutor) {
        for(int i=1;i<7;i++){
            int finalI = i;
            try{
                callerRunExecutor.submit(
                        () -> {
                            System.out.println("Task " + finalI + " started on " + Thread.currentThread().getName());
                            try {
                                Thread.sleep(10000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        });
            }catch (RejectedExecutionException e){
                System.out.println("Task "+ finalI + " rejected on " + Thread.currentThread().getName());
            }
        }
    }

    private static void abortPolicy(ExecutorService abortPolicyExecutor) {
        for(int i=1;i<7;i++){
            int finalI = i;
            try{
                abortPolicyExecutor.submit(
                        () -> {
                            System.out.println("Task "+ finalI + " started on " + System.currentTimeMillis());
                        });
            }catch (RejectedExecutionException e){
                System.out.println("Task "+ finalI + " rejected on " + System.currentTimeMillis());
            }
        }
    }
}
