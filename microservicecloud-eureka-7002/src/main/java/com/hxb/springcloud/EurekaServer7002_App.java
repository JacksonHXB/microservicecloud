package com.hxb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//启动该新组件的相关注解标签
public class EurekaServer7002_App {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServer7002_App.class, args);
	}
}










































