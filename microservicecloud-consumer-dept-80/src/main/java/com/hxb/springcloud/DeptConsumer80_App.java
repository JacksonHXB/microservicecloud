package com.hxb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.hxb.myrule.MySelfRule;

@SpringBootApplication
@EnableEurekaClient   //用户端也是服务注册中心Eureka的客户端
@RibbonClient(name="MICROSERVICECLOUD-DEPT", configuration=MySelfRule.class)//在启动该微服务时候就能去加载我们自定义的Ribbon配置类，从而使配置生效
public class DeptConsumer80_App {
	public static void main(String[] args){
		SpringApplication.run(DeptConsumer80_App.class, args);
	}
}
