package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.demo" })
public class AppTest 
{
	public static void main(String[] args) {
		SpringApplication.run(AppTest.class, args);
	}
}
