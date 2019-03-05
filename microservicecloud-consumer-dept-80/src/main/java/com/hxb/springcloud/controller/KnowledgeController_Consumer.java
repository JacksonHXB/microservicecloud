package com.hxb.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hxb.springcloud.entites.RespEntity;

@RestController
public class KnowledgeController_Consumer {
	//private static final String REST_URL_PREFIX = "http://localhost:8001";         //直接指定微服务的地址
	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-ECONOMY";   //在使用Ribbon后注册到Eureka中，就可以通过访问微服务名称（通过Eureka）找到该服务

	@Autowired
	private RestTemplate restTemplate;//RestTemplate提供了多种便捷访问远程HTTP服务的方法
	
	
	/*查询知识*/
	@RequestMapping(value="/consumer/knowledge/search/{page}")
	public RespEntity get(@PathVariable("page")String page, String size, String sort, String keyword){
		
		RespEntity forObject = restTemplate.getForObject(REST_URL_PREFIX+"/knowledge/search/"+page, RespEntity.class);
		System.out.println(forObject);
		return restTemplate.getForObject(REST_URL_PREFIX+"/knowledge/search/"+page, RespEntity.class);
	}

	
	
	/*测试@EnableDiscoveryClient,消费端可以调用服务发现*/
//	@RequestMapping(value="/consumer/dept/discovery")
//	public Object discovery(){
//		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery", Object.class);
//	}
}





































































