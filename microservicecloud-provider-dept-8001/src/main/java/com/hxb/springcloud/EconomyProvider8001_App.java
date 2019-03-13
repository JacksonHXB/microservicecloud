package com.hxb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableEurekaClient//将该服务注册至Eureka的服务列表中
@EnableDiscoveryClient //Eureka做服务发现
public class EconomyProvider8001_App {
	public static void main(String[] args) {
		SpringApplication.run(EconomyProvider8001_App.class, args);
	}
}
