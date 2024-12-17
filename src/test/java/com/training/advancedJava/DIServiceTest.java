package com.training.advancedJava;

import com.training.advancedJava.service.DependencyInjection;
import com.training.advancedJava.service.IDependencyInjection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DIServiceTest {

    private final IDependencyInjection dependencyInjection=new DependencyInjection();

    @Test
    public void testDI(){
        String response=dependencyInjection.greet("test");
        assertEquals("Dependency Injection example : test",response);
    }
}
