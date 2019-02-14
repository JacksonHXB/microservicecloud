package com.hxb.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class ConfigBean {
	
	@Bean
	@LoadBalanced   //Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端负载均衡工具,默认是轮询算法
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	/*在这里也可以使用负载均衡算法*/
//	@Bean
//	public IRule myRule(){//将Robbin的负载均衡算法改为随机算法
//		return new RandomRule();//会默认覆盖原有的轮询算法
//	}
}





































