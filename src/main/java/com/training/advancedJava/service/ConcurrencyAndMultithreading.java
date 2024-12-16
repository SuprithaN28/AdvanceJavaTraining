package com.training.advancedJava.service;


import com.training.advancedJava.util.RecursiveSumTask;
import com.training.advancedJava.util.ThreadOne;
import com.training.advancedJava.util.ThreadTwo;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Service
public class ConcurrencyAndMultithreading implements IConcurrencyAndMultithreading {

    @Override
    public void mutliThreadingProgram() {

        System.out.println("---------MultiThreading---------");
        Runnable obj1 = new ThreadOne();
        Runnable obj2 = new ThreadTwo();

        // Creating reference of thread class by passing object of Runnable in constructor of Thread class
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();
    }

    @Override
    public void executorsAndThreadPool() throws InterruptedException {
        System.out.println("---------Executors And Thread Pool---------");
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        IntStream.range(1,6).forEach(i->executorService.execute(()->{
            System.out.println("Task "+i+" is running on thread : "+Thread.currentThread().getName());
        }));
        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);
    }

    @Override
    public void forkAndJoin() {
        System.out.println("---------Fork And Join---------");
            ForkJoinPool forkJoinPool=new ForkJoinPool();
            int[] numbers =IntStream.rangeClosed(1,1000).toArray();
            RecursiveSumTask task=new RecursiveSumTask(numbers,0,numbers.length);
            Integer result=forkJoinPool.invoke(task);
        System.out.println("sum of numbers 1 to 1000 :"+result);

    }

    @Override
    public void virtualThreads() {
        System.out.println("---------Virtual Threads---------");
        try(var virtualThreadExecutor=Executors.newThreadPerTaskExecutor(Thread.ofVirtual().factory())){
            IntStream.range(1,6).forEach(i->virtualThreadExecutor.submit(()->{
                System.out.println("Virtual Thread Task "+i+" running on thread: "+Thread.currentThread().getName());
            }));
        }
    }

    @Override
    public void bestPracticeForCuncurrentCode() {
        System.out.println("---------Best Practices for Concurrent Code---------");
        useSynchronizedBlock();
    }

private static void useSynchronizedBlock(){
        Object lock=new Object();
        ExecutorService executorService=Executors.newFixedThreadPool(3);
        Runnable task=()->{
            synchronized (lock){
                System.out.println("Synchronized block : Excecuted by : "+Thread.currentThread().getName());
            }
        };
        IntStream.range(1,4).forEach(i->executorService.submit(task));
        executorService.shutdown();
}

}
