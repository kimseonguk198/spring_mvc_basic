package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//어노테이션 : 스프링에서 지원하는 다양한 어노테이션 중에 하나
//스프링부트를 통해 앱을 실행하려면 SpringBootApplication 어노테이션이 있어야 한다.
@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
