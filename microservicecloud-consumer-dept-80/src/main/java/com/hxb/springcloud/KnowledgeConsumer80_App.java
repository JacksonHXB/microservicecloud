package com.hxb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient   //用户端也是服务注册中心Eureka的客户端
@EnableFeignClients(basePackages= {"com.hxb.springcloud"})//在启用Fegin之后，使用面向接口编程，而不是使用Ribbon来
@ComponentScan("com.hxb.springcloud")
@EnableSwagger2					//使用Swagger自动生成API文档http://localhost:80/swagger-ui.html
public class KnowledgeConsumer80_App {
	public static void main(String[] args){
		SpringApplication.run(KnowledgeConsumer80_App.class, args);
	}
}
