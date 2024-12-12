package com.training.advancedJava.service;

import com.training.advancedJava.exceptions.CustomExceptions;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class JavaBasics implements IJavaBasics{


    @Override
    public void genericsAndCollections() {
        System.out.println("---------Generics and Collections---------");
        List<String> names = new ArrayList<>();
        names.add("a");
        names.add("b");
        names.add("c");
        System.out.println("ArrayList " + names);

        Map<Integer, String> ids = new HashMap<>();
        ids.put(1, "a");
        ids.put(2, "b");
        System.out.println("HashMap " + ids);

        ConcurrentHashMap<Integer,String> hashMap=new ConcurrentHashMap<>();
        hashMap.put(1,"hm1");
        hashMap.put(2,"hm2");
        System.out.println("ConcurrentHashMap "+ hashMap);

        LinkedHashSet<String> set=new LinkedHashSet<String>();
        set.add("a");
        set.add("a");
        set.add("b");
        Iterator<String> itr=set.iterator();
        int index=0;
        while(itr.hasNext()){
            System.out.println("LinkedHashSet number "+ index +" "+itr.next());
            index++;
        }
    }

    @Override
    public void customExceptionHandling() throws CustomExceptions {


        System.out.println("---------Custom Exception Handling---------");
       try{ throwCustomException(0);}
       catch(CustomExceptions e){
           System.out.println("caught custom exception " +e.getMessage());

       }
       catch (Exception e){
           System.out.println("caught general Exception "+e.getMessage());
       }
    }

    @Override
    public void java8Features() {

        System.out.println("---------Java 8 Features---------");
        List<Integer> numbers =Arrays.asList(1,2,3,4, 5,6);
        int sum= numbers.stream().filter(n->n %2==0).mapToInt(Integer::intValue).sum();
        System.out.println("Lamda and stream example "+sum);

       String find=findById(2).orElse("Unknown");
        System.out.println("Optional Example "+find);

        LocalDate today=LocalDate.now();
        System.out.println("date API Example "+today);

        LocalDate futureDate=today.plusDays(10);
        System.out.println("future date "+futureDate);
    }


    public static void throwCustomException(int value) throws CustomExceptions {
        if(value==0){
            System.out.println("custom Exception Thrown");
            throw new CustomExceptions("value cannot be 0");
        }

    }
 public static Optional<String> findById(int id){
     Map<Integer, String> ids = new HashMap<>();
     ids.put(1, "a");
     ids.put(2, "b");
     return Optional.ofNullable(ids.get(id));
 }


}
