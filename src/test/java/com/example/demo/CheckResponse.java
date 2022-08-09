package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.internal.junit.JUnitTestRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CheckResponse {
    @LocalServerPort
    private int port ;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void shouldPassIfMatch(){
        assertEquals ("Hello World ", testRestTemplate.getForObject( "http://localhost:"+port+"/template/products", String.class));}
}
