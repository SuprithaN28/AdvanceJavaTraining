package com.training.advancedJava.util;

import com.training.advancedJava.service.Shape;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}