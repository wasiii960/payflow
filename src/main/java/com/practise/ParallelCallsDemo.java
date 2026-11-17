package com.practise;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelCallsDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        long startTime = System.currentTimeMillis();
        System.out.println("Start time "+ startTime);
        System.out.println(getUser());
        System.out.println(getBalance());
        System.out.println(getRate());
        long endTime = System.currentTimeMillis();
        long finalTime = endTime-startTime;
        System.out.println("End time "+ finalTime);

        System.out.println("=================================================");
         startTime = System.currentTimeMillis();
        System.out.println("Start time "+ startTime);


        CompletableFuture<String> userFuture = CompletableFuture.supplyAsync(()-> {
            try {
                return getUser();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },executor);
        CompletableFuture<Integer> balanceFuture = CompletableFuture.supplyAsync(()-> {
            try {
                return getBalance();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },executor);
        CompletableFuture<Integer> rateFuture =CompletableFuture.supplyAsync(()-> {
            try {
                return getRate();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },executor);

        CompletableFuture.allOf(userFuture,balanceFuture,rateFuture).join();
        System.out.println(userFuture.get());
        System.out.println(balanceFuture.get());
        System.out.println(rateFuture.get());

        endTime = System.currentTimeMillis()-startTime;
        System.out.println("End time "+ endTime);

    }

    private static int getRate() throws InterruptedException {
        Thread.sleep(1000);
        return 280;
    }

    private static int getBalance() throws InterruptedException {
        Thread.sleep(1000);
        return 5000;
    }

    private static String getUser() throws InterruptedException {
        Thread.sleep(1000);
        return "Wasif";
    }
}
