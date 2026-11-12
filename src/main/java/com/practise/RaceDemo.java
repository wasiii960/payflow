package com.practise;

import java.util.concurrent.atomic.AtomicInteger;

public class RaceDemo {
    private static final int INCREMENTS = 1_000_000;
    static class UnsafeCounter{
        private int count=0;
        void increment(){count++;}
        int get(){return count;}
    }
    static class SyncCounter{
        private int count=0;
        synchronized void increment(){
            count++;
        }
        synchronized int get(){return count;}
    }
    static class AtomicCounter{
    private final AtomicInteger count = new AtomicInteger();

        void increment(){
            count.incrementAndGet();
        }
        int get(){return count.get();}
    }
    private static long runTwoThreads(Runnable task) throws InterruptedException {
        Thread t1=new Thread(task);
        Thread t2=new Thread(task);
        long start=System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        return (System.nanoTime()-start)/1_000_000;
    }
    public static void main(String[] args) throws InterruptedException {
        UnsafeCounter unsafeCounter=new UnsafeCounter();
        SyncCounter syncCounter=new SyncCounter();
        AtomicCounter atomicCounter=new AtomicCounter();
        long unsafeMs = runTwoThreads(()->{
            for(int i=0;i<INCREMENTS;i++){
                unsafeCounter.increment();
            }
        });
        long syncMs = runTwoThreads(()->{
            for(int i=0;i<INCREMENTS;i++){
                syncCounter.increment();
            }
        });
        long atomicMs = runTwoThreads(()->{
            for(int i=0;i<INCREMENTS;i++){
                atomicCounter.increment();
            }
        });
        System.out.println("Expected:      " + (2 * INCREMENTS));
        System.out.println("Unsafe:        " + unsafeCounter.get() + "  (" + unsafeMs + " ms)");
        System.out.println("synchronized:        " + syncCounter.get() + "  (" + syncMs + " ms)");
        System.out.println("Atomic:          " + atomicCounter.get() + "  (" + atomicMs + " ms)");
    }
}
