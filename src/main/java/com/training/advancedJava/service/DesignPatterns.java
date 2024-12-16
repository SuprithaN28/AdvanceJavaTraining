package com.training.advancedJava.service;

import com.training.advancedJava.util.ShapeFactory;
import com.training.advancedJava.util.Singleton;
import org.springframework.stereotype.Service;

@Service
public class DesignPatterns implements IDesignpatterns {
    @Override
    public void singletonInstance() {
        System.out.println("-------------Singleton Pattern-------------");
        Singleton instance=Singleton.getInstance();
        instance.showMessage();
    }

    @Override
    public void factorypattern() {
        System.out.println("--------------Factory Pattern--------------");
        ShapeFactory shapeFactory=new ShapeFactory();
        Shape circle= shapeFactory.getShape("Circle");
        circle.draw();

        Shape rectangle= shapeFactory.getShape("Rectangle");
        rectangle.draw();
    }
}
