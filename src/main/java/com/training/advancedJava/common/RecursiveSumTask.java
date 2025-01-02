package com.training.advancedJava.common;

import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class RecursiveSumTask  extends RecursiveTask<Integer> {

    private final int[] numbers;
    private final int start;
    private final int end;
    private static final int THRESHOLD= 20;

    public RecursiveSumTask(int[] numbers, int start, int end){
        this.numbers=numbers;
        this.start=start;
        this.end=end;
    }

    @Override
    protected Integer compute() {
        if(end-start<=THRESHOLD){
            return IntStream.range(start,end).map(i->numbers[i]).sum();
        }
        else{
            int mid=(start+end)/2;
            RecursiveSumTask leftTask=new RecursiveSumTask(numbers,start,mid);
            RecursiveSumTask rightTask=new RecursiveSumTask(numbers,mid,end);
            leftTask.fork();
            return rightTask.compute()+leftTask.join();
        }
    }
}
