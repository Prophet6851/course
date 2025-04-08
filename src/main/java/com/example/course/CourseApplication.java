package com.example.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication 是一个复合注解，包含 @Configuration、@EnableAutoConfiguration 和 @ComponentScan
// 它标识这是一个 Spring Boot 应用的主类
@SpringBootApplication
public class CourseApplication {

	// main 方法是 Java 应用程序的入口
	// SpringApplication.run 方法启动 Spring Boot 应用
	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);
	}
}