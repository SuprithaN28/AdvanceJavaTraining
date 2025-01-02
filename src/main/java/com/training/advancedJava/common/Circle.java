package com.training.advancedJava.common;

import com.training.advancedJava.service.Shape;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}
