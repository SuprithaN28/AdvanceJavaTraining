package com.training.advancedJava.common;

public class ThreadTwo implements Runnable {



    @Override
    public void run() {
        for(int  i=0;i<5;i++){

            System.out.println("Thread 2 is executing");

            try {
                Thread.sleep(1000);
                System.out.println("Thread 2 is paused");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread 2 had finished executing");
    }
}
