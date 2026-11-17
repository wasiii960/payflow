package com.practise;

import java.util.concurrent.Executors;

public class VirtualThreadsDemo {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try(var executor = Executors.newFixedThreadPool(100)){
            for (int i = 1; i <= 10_000; i++) {
                final int n = i;          // copy, because a lambda can only use final variables
                executor.submit(() -> {
                    if (n % 1000 == 0) {
                        System.out.println("Task " + n + " on " + Thread.currentThread());
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        }
        long end = System.currentTimeMillis();
    System.out.println("End time "+(end-start));

    System.out.println("============================");
         start = System.currentTimeMillis();
        try(var executor = Executors.newVirtualThreadPerTaskExecutor()){
            for (int i = 1; i <= 10_000; i++) {
                final int n = i;          // copy, because a lambda can only use final variables
                executor.submit(() -> {
                    if (n % 1000 == 0) {
                        System.out.println("Task " + n + " on " + Thread.currentThread());
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        }
         end = System.currentTimeMillis();
        System.out.println("End time "+(end-start));
    }
}
