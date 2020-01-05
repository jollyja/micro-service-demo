package com.nightpower.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.nightpower.demo.dao")
public class DemoApp {
	public static void main(String[] args) {
		SpringApplication.run(DemoApp.class);
	}
}
