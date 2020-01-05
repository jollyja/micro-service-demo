package com.nightpower.demo.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.nightpower.demo.model.io.HelloResponse;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

	@Test
	void testGetHello() {
		HelloResponse res = restTemplate.getForObject("/hello/getHello/pathxxx?name=tom&amount=123.456&indication=true", HelloResponse.class);
		assertNotNull(res);
		assertEquals("Mr/Ms tom", res.getHelloName());
	}

}
