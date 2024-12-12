package com.training.advancedJava.service;

 class GarbageCollectionClass {

     private String name;

     public GarbageCollectionClass(String name){
         this.name=name;
     }
     public  String getName(){
         return name;
     }

     @Override
    protected void finalize() throws Throwable {
        System.out.println("this is being collected by garbage collector");
    }
}
