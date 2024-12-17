package com.training.advancedJava;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DIControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testController(){
        String response=restTemplate.getForObject("/spring/DI?name=test",String.class);
        assertEquals("Dependency Injection example : test",response);
    }
}
