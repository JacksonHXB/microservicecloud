package com.hxb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient   //用户端也是服务注册中心Eureka的客户端
//@RibbonClient(name="MICROSERVICECLOUD-ECONOMY", configuration=MySelfRule.class)//在启动该微服务时候就能去加载我们自定义的Ribbon配置类，从而使配置生效
@EnableFeignClients(basePackages= {"com.hxb.springcloud"})//在启用Fegin之后，使用面向接口编程，而不是使用Ribbon来
@ComponentScan("com.hxb.springcloud")
public class KnowledgeConsumer80_App {
	public static void main(String[] args){
		SpringApplication.run(KnowledgeConsumer80_App.class, args);
	}
}
