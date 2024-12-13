package com.training.advancedJava.service;

public class ThreadOne implements Runnable {



    @Override
    public void run() {
        for(int  i=0;i<5;i++){

            System.out.println("Thread 1 is executing");

            try {
                Thread.sleep(1000);
                System.out.println("Thread 1 is paused");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread 1 had finished executing");
    }
}
